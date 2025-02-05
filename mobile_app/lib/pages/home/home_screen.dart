import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:fuel_scanner/pages/qr_scanner/qr_scanner_screen.dart';
import 'package:fuel_scanner/constants/app_colors.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({Key? key}) : super(key: key);

  Future<void> _openQRScanner(BuildContext context) async {
    final result = await Navigator.push<String>(
      context,
      MaterialPageRoute(
        builder: (context) => const QRScannerScreen(),
      ),
    );

    if (result != null && context.mounted) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: Text('Scanned QR Code: $result'),
          behavior: SnackBarBehavior.floating,
        ),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Dashboard'),
        actions: [
          IconButton(
            icon: const Icon(Icons.logout),
            onPressed: () => Get.offAllNamed('/login'),
          ),
        ],
      ),
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              ElevatedButton.icon(
                onPressed: () => _openQRScanner(context),
                icon: const Icon(Icons.qr_code_scanner),
                label: const Text('Scan QR Code'),
                style: ElevatedButton.styleFrom(
                  padding: const EdgeInsets.symmetric(vertical: 12, horizontal: 24),
                ),
              ),
              const SizedBox(height: 24),
              Text(
                "Transaction History",
                style: Theme.of(context).textTheme.titleLarge,
              ),
              const SizedBox(height: 16),
              Expanded(
                child: ListView.builder(
                  itemCount: 10,
                  itemBuilder: (context, index) {
                    // Sample vehicle numbers with ABC-1234 format
                    final vehicles = ['ABC-1234', 'XYZ-5678', 'PQR-9012', 'MNO-3456', 'DEF-7890'];
                    
                    // Sample fuel amounts between 0-20L
                    final amounts = [12.5, 18.2, 15.8, 9.4, 16.7];
                    
                    // Sample dates with time
                    final dates = List.generate(
                      10,
                      (i) => DateTime.now().subtract(Duration(hours: i * 8)),
                    );

                    return Card(
                      margin: const EdgeInsets.only(bottom: 12),
                      child: ListTile(
                        leading: CircleAvatar(
                          backgroundColor: AppColors.primary,
                          child: const Icon(Icons.local_gas_station, color: Colors.white),
                        ),
                        title: Text(
                          'Vehicle: ${vehicles[index % vehicles.length]}',
                          style: Theme.of(context).textTheme.bodyLarge,
                        ),
                        subtitle: Text(
                          'Amount: ${amounts[index % amounts.length].toStringAsFixed(1)} L',
                          style: Theme.of(context).textTheme.bodyMedium,
                        ),
                        trailing: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          crossAxisAlignment: CrossAxisAlignment.end,
                          children: [
                            Text(
                              dates[index].toString().split(' ')[0],
                              style: TextStyle(color: AppColors.textLight),
                            ),
                            Text(
                              dates[index].toString().split(' ')[1].substring(0, 5),
                              style: TextStyle(color: AppColors.textLight),
                            ),
                          ],
                        ),
                      ),
                    );
                  },
                ),
              ),
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () => _openQRScanner(context),
        child: const Icon(Icons.qr_code_scanner),
      ),
    );
  }
}
