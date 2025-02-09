import 'package:flutter/material.dart';
import 'package:fuel_scanner/pages/home/home_screen.dart';
import 'package:fuel_scanner/pages/login/login_controller.dart';
import 'package:fuel_scanner/pages/login/login_screen.dart';
import 'package:fuel_scanner/pages/register/register_controller.dart';
import 'package:fuel_scanner/pages/register/register_screen.dart';
import 'package:fuel_scanner/services/api_service.dart';
import 'package:fuel_scanner/services/storage_service.dart';
import 'package:get/get.dart';
import 'package:fuel_scanner/repositories/employee_repository.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  // Initialize repositories
  Get.put(EmployeeRepository());
  Get.put(StorageService());
  Get.put(ApiService());

  StorageService storageService = StorageService();

  String? token = await storageService.getString('token');
  if (token != null) {
    ApiService.token = token;
  }

  runApp(MyApp(token: token));
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key, required this.token}) : super(key: key);

  final String? token;

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      title: 'Fuel Scanner',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        scaffoldBackgroundColor: Colors.white,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      debugShowCheckedModeBanner: false,
      initialRoute: token != null
          ? '/home'
          : '/login', // Set initial route to register page
      getPages: [
        GetPage(
          name: '/register',
          page: () => const RegisterScreen(),
          binding: BindingsBuilder(() {
            Get.lazyPut(() => RegisterController());
          }),
        ),
        GetPage(
          name: '/login',
          page: () => const LoginScreen(),
          binding: BindingsBuilder(() {
            Get.lazyPut(() => LoginController());
          }),
        ),
        GetPage(
          name: '/home',
          page: () => const HomeScreen(),
          binding: BindingsBuilder(() {
            // Get.lazyPut(() => HomeController());
          }),
        ),
        // Add other routes as needed
      ],
    );
  }
}
