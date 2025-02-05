import 'login_controller.dart';
import 'widgets/login_form.dart';
import 'package:flutter/material.dart';
import '../../../constants/app_colors.dart';
import '../../../constants/app_text_styles.dart';

class LoginScreen extends StatelessWidget {
  final LoginController controller = LoginController();

  LoginScreen({super.key});
  

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: AppColors.background,
      body: SafeArea(
        child: SingleChildScrollView(
          padding: const EdgeInsets.all(24.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              const SizedBox(height: 48),
              const SizedBox(height: 32),
              LoginForm(controller: controller),
            ],
          ),
        ),
      ),
    );
  }
} 