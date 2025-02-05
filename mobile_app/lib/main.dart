// import 'package:fuel_scanner/repositories/employee_repository.dart';
// import 'package:get/get.dart';
// import 'package:flutter/services.dart';
// import 'package:flutter/material.dart';
// import 'app_theme.dart';
// import 'services/storage_service.dart';
// import 'pages/login/login_screen.dart';
// import 'pages/register/register_screen.dart';
// import 'services/auth_service.dart';
// import 'services/api_service.dart';

// // void main() async {
// //   WidgetsFlutterBinding.ensureInitialized();

// //   // Initialize services
// //   final storageService = StorageService();
// //   await storageService.init();

// //   // Initialize AuthService
// //   Get.put(AuthService());
// //   Get.put(storageService);
// //   Get.put(ApiService());
// //   runApp(const MyApp());
// // }

// void main() async {
//   WidgetsFlutterBinding.ensureInitialized();

//   await Get.putAsync(() => StorageService().init());
//   Get.put(AuthService());
//   Get.put(EmployeeRepository());

//   runApp(MyApp());
// }

// class MyApp extends StatelessWidget {
//   const MyApp({super.key});

//   @override
//   Widget build(BuildContext context) {
//     SystemChrome.setSystemUIOverlayStyle(
//       const SystemUiOverlayStyle(
//         statusBarColor: Colors.transparent, // Set this to any color you want.
//         statusBarIconBrightness:
//             Brightness.dark, // Makes the status bar icons dark.
//       ),
//     );
//     return GetMaterialApp(
//       title: 'Fuel Master',
//       debugShowCheckedModeBanner: false,
//       theme: AppTheme.light,
//       defaultTransition: Transition.rightToLeftWithFade,
//       initialRoute: '/login',
//       getPages: [
//         GetPage(
//           name: '/login',
//           page: () => LoginScreen(),
//         ),
//         GetPage(
//           name: '/register',
//           page: () => const RegisterScreen(),
//         ),
//       ],
//     );
//   }
// }

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
