import 'dart:convert';

import 'package:dio/dio.dart';
import 'package:fuel_scanner/services/api_service.dart';
import 'package:fuel_scanner/services/storage_service.dart';
import 'package:get/get.dart';
import '../models/employee.dart';

class EmployeeRepository extends GetxController {
  StorageService storageService = StorageService();
  ApiService apiService = ApiService();

  final Dio _dio = Dio(BaseOptions(
    baseUrl: 'http://10.0.2.2:8080/api/v1', // Changed from localhost
    headers: {'Content-Type': 'application/json'},
  ));

  // Observable for current employee
  final Rx<Employee?> _currentEmployee = Rx<Employee?>(null);
  Employee? get currentEmployee => _currentEmployee.value;

  // Login method
  // Future<Employee> loginEmployee(String username, String password) async {
  //   try {
  //     print('Login attempt with username: $username'); // Debug print

  //     final response = await _dio.post('/auth/employeeAuth', data: {
  //       'username': username,
  //       'password': password,
  //     });

  //     print('Login response: ${response.data}'); // Debug print

  //     if (response.statusCode == 200) {
  //       return Employee.fromJson(response.data);
  //     } else {
  //       throw Exception('Login failed: ${response.statusCode}');
  //     }
  //   } on DioException catch (e) {
  //     print('Login error: ${e.response?.data}');
  //     throw Exception('Login failed: ${e.message}');
  //   }
  // }

  Future<Employee> loginEmployee(String username, String password) async {
    try {
      final response = await _dio.post(
        '/auth/employeeAuth',
        data: {
          'username': username,
          'password': password,
        },
      );

      if (response.statusCode == 200) {
        final data = response.data as Map<String, dynamic>;
        final employeeData = data['user'] as Map<String, dynamic>;
        final token = data['token'] as String;

        bool isset = await storageService.setString('token', token);
        await storageService.setString('employee', jsonEncode(employeeData));

        print("token set ${isset ? 'Done' : 'n'}");

        print(storageService.getString('token'));

        apiService.setToken(token);

        // Create an Employee object and include the token
        final employee = Employee.fromJson(employeeData).copyWith(token: token);
        _currentEmployee.value = employee; // Store the logged-in employee

        return employee;
      } else {
        throw Exception('Login failed: ${response.data['message']}');
      }
    } on DioException catch (e) {
      print(e.response?.data);
      throw Exception(e.response?.data ?? 'Invalid username or password');
    }
  }

  // Register method
  Future<Employee> registerEmployee({
    required String name,
    required String email,
    required String password,
    required int fuelStationId,
  }) async {
    try {
      final response = await _dio.post('/employee', data: {
        'employeeUsername': name,
        'employeeEmail': email,
        'password': password,
        'fuelStationId': fuelStationId,
      });

      if (response.statusCode == 201) {
        final employee = Employee.fromJson(response.data);
        return employee;
      } else {
        throw Exception('Registration failed: ${response.statusCode}');
      }
    } on DioException catch (e) {
      print('Registration error: ${e.response?.data}');
      throw Exception('Registration failed: ${e.message}');
    }
  }

  // Logout method
  void logout() {
    _currentEmployee.value = null;
  }

  // Check login status
  bool get isLoggedIn => _currentEmployee.value != null;
}
