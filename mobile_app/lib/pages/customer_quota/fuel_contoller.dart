import 'package:get/get.dart';
import 'package:flutter/material.dart';
import '../../services/api_service.dart';

class FuelController {
  TextEditingController fuelQuotaController = TextEditingController();

  Future<void> updateFuelQuota(String qrId) async {
    final fuelQuota = fuelQuotaController.text;
    final apiService = ApiService();
    try {
      bool val =
          await apiService.updateFuelQuota(qrId, double.parse(fuelQuota));
      print(val);
      if (val) {
        print('success');

        Get.back(result: true);
        Get.snackbar(
          'Success',
          'Fuel quota updated successfully',
          snackPosition: SnackPosition.BOTTOM,
          backgroundColor: Colors.green,
          colorText: Colors.white,
        );
      } else {
        Get.snackbar(
          'Error',
          'Failed to update fuel quota',
        );
      }
    } on Exception catch (e) {
      print(e);

      Get.snackbar(
        'Error',
        "${e.toString()}",
        snackPosition: SnackPosition.BOTTOM,
        backgroundColor: Colors.red,
        colorText: Colors.white,
      );
    }
  }
}
