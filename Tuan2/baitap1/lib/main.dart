import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Thực hành 01',
      theme: ThemeData(primarySwatch: Colors.blue),
      home: AgeCheckerPage(),
    );
  }
}

class AgeCheckerPage extends StatefulWidget {
  @override
  _AgeCheckerPageState createState() => _AgeCheckerPageState();
}

class _AgeCheckerPageState extends State<AgeCheckerPage> {
  final TextEditingController _nameController = TextEditingController();
  final TextEditingController _ageController = TextEditingController();
  String result = '';

  void _checkAge() {
    String name = _nameController.text;
    int? age = int.tryParse(_ageController.text);

    if (name.isEmpty || age == null) {
      setState(() {
        result = 'Vui lòng nhập đầy đủ tên và tuổi hợp lệ!';
      });
      return;
    }

    String group;
    if (age > 65) {
      group = 'Người già';
    } else if (age >= 6) {
      group = 'Người lớn';
    } else if (age >= 2) {
      group = 'Trẻ em';
    } else {
      group = 'Em bé';
    }

    setState(() {
      result = 'Tên: $name\nTuổi: $age\nBạn là: $group';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('THỰC HÀNH 01')),
      body: Padding(
        padding: EdgeInsets.all(16),
        child: Column(
          children: [
            TextField(
              controller: _nameController,
              decoration: InputDecoration(labelText: 'Nhập họ và tên'),
            ),
            SizedBox(height: 16),
            TextField(
              controller: _ageController,
              decoration: InputDecoration(labelText: 'Tuổi'),
              keyboardType: TextInputType.number,
            ),
            SizedBox(height: 24),
            ElevatedButton(
              onPressed: _checkAge,
              child: Text('Kiểm tra'),
            ),
            SizedBox(height: 24),
            Text(
              result,
              style: TextStyle(fontSize: 18),
            ),
          ],
        ),
      ),
    );
  }
}
