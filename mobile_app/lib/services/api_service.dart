import 'package:dio/dio.dart';
import 'package:fuel_scanner/models/customer_fuel_data.dart';
import '../models/fuel_station.dart';

class ApiService {
  static final ApiService _instance = ApiService._internal();

  static const String _baseUrl = 'http://10.162.223.234:8080/api/v1';
  static String token = 'abcd1234';

  late final Dio _dio;

  ApiService._internal() {
    _dio = Dio(
      BaseOptions(
        baseUrl: _baseUrl,
        headers: {
          'Content-Type': 'application/json',
          // 'Authorization': 'Bearer $token'
        },
      ),
    );
  }

  factory ApiService() {
    return _instance;
  }

  void setToken(String token) {
    ApiService.token = 'Bearer $token';
  }

  // Generic GET request
  Future<Map<String, dynamic>> get(String endpoint) async {
    try {
      final response = await _dio.get(endpoint);
      return response.data;
    } on DioException catch (e) {
      throw Exception('Network error: ${e.response?.data}');
    }
  }

  // Generic POST request
  Future<Map<String, dynamic>> post(
      String endpoint, Map<String, dynamic> body) async {
    try {
      final response = await _dio.post(endpoint, data: body);
      return {"staus": response.statusCode, "data": response.data};
    } on DioException catch (e) {
      throw Exception('Network error: ${e.message}');
    }
  }

  // Generic PUT request
  Future<Map<String, dynamic>> put(
      String endpoint, Map<String, dynamic> body) async {
    try {
      final response = await _dio.put(endpoint, data: body);
      return response.data;
    } on DioException catch (e) {
      throw Exception('Network error: ${e.message}');
    }
  }

  // Generic DELETE request
  Future<bool> delete(String endpoint) async {
    try {
      final response = await _dio.delete(endpoint);
      return response.statusCode == 200 || response.statusCode == 204;
    } on DioException catch (e) {
      throw Exception('Network error: ${e.message}');
    }
  }

  Future<List<FuelStation>> getAllFuelStations() async {
    try {
      print('Fetching fuel stations...'); // Debug print
      Dio _no_token_dio = Dio(
        BaseOptions(
          baseUrl: _baseUrl,
          headers: {
            'Content-Type': 'application/json',
          },
        ),
      );
      final response = await _no_token_dio.get('/fuelStation');
      print('Response status: ${response.statusCode}'); // Debug print
      print('Response data: ${response.data}'); // Debug print

      if (response.statusCode == 200) {
        final List<dynamic> data = response.data as List;
        return data.map((json) => FuelStation.fromJson(json)).toList();
      } else {
        throw Exception(
            'Server returned ${response.statusCode}: ${response.data}');
      }
    } catch (e) {
      print('Error fetching fuel stations: $e');
      throw Exception('Failed to load fuel stations: ${e.toString()}');
    }
  }

  Future<CustomerFuelData> getCustomerFuelData(String qr) async {
    try {
      print('Fetching fuel stations...'); // Debug print
      Dio _no_token_dio = Dio(
        BaseOptions(
          baseUrl: _baseUrl,
          headers: {
            'Content-Type': 'application/json',
          },
        ),
      );
      final response = await _no_token_dio.get('/vehicle/qr/' + qr);
      print('Response status: ${response.statusCode}'); // Debug print
      print('Response data: ${response.data}'); // Debug print

      if (response.statusCode == 200) {
        try {
          return CustomerFuelData.fromJson(response.data);
        } on Exception catch (e) {
          print('Error fetching fuel data: $e');
          throw Exception('Failed to load fuel data: ${e.toString()}');
        }
      } else {
        throw Exception(
            'Server returned ${response.statusCode}: ${response.data}');
      }
    } catch (e) {
      print('Error fetching fuel stations: $e');
      throw Exception('Failed to load fuel stations: ${e.toString()}');
    }
  }

  Future<bool> updateFuelQuota(String qrId, double fuelQuota) async {
    try {
      final response = await _dio
          .post('/vehicle/fuel-update/$qrId', data: {'amount': fuelQuota});
      print(response.statusCode);
      return response.statusCode == 200;
    } on DioException catch (e) {
      print(e);
      throw Exception('${e.response?.data}');
    } catch (e) {
      throw Exception('Failed to update fuel quota: ${e.toString()}');
    }
  }
}
