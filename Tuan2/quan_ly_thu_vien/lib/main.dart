import 'package:flutter/material.dart';

void main() {
  runApp(ThuVienApp());
}

class ThuVienApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Quản lý Thư viện',
      home: ThuVienScreen(),
      debugShowCheckedModeBanner: false,
    );
  }
}

class ThuVienScreen extends StatefulWidget {
  @override
  _ThuVienScreenState createState() => _ThuVienScreenState();
}

class _ThuVienScreenState extends State<ThuVienScreen> {
  final TextEditingController _tenNguoiDungController = TextEditingController();
  final List<String> _dsNguoiDung = []; // Danh sách người dùng
  String? _nguoiDungDangChon; // Người dùng hiện tại được chọn
  final List<String> _danhSachSach = ['Sách A', 'Sách B', 'Sách C'];
  String? _sachDangChon; // Sách được chọn
  final Map<String, List<String>> _lichSuMuon = {}; // Lịch sử mượn sách theo người dùng

  void _themNguoiDung() {
    String tenMoi = _tenNguoiDungController.text.trim();
    if (tenMoi.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Vui lòng nhập tên người dùng')),
      );
      return;
    }

    // Kiểm tra trùng, nếu chưa có thì thêm vào danh sách
    if (!_dsNguoiDung.contains(tenMoi)) {
      setState(() {
        _dsNguoiDung.add(tenMoi);
      });
    }

    setState(() {
      _nguoiDungDangChon = tenMoi;
    });

    _tenNguoiDungController.clear();
  }

  void _muonSach() {
    if (_nguoiDungDangChon == null || _nguoiDungDangChon!.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Vui lòng chọn người dùng')),
      );
      return;
    }

    if (_sachDangChon == null) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Vui lòng chọn sách')),
      );
      return;
    }

    setState(() {
      _lichSuMuon[_nguoiDungDangChon!] ??= [];
      _lichSuMuon[_nguoiDungDangChon!]!.add(_sachDangChon!);
    });

    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(content: Text('${_nguoiDungDangChon!} đã mượn $_sachDangChon!')),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Hệ thống Quản lý Thư viện'),
        centerTitle: true,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text('Nhập tên người dùng:', style: TextStyle(fontSize: 16)),
            Row(
              children: [
                Expanded(
                  child: TextField(
                    controller: _tenNguoiDungController,
                    decoration: InputDecoration(
                      hintText: 'Nhập tên...',
                    ),
                  ),
                ),
                SizedBox(width: 8),
                ElevatedButton(
                  onPressed: _themNguoiDung,
                  child: Text('Thêm'),
                ),
              ],
            ),
            SizedBox(height: 20),
            Text('Chọn người dùng:', style: TextStyle(fontSize: 16)),
            DropdownButton<String>(
              value: _nguoiDungDangChon,
              hint: Text('Chọn người dùng'),
              items: _dsNguoiDung
                  .map((nguoiDung) => DropdownMenuItem<String>(
                child: Text(nguoiDung),
                value: nguoiDung,
              ))
                  .toList(),
              onChanged: (value) {
                setState(() {
                  _nguoiDungDangChon = value;
                });
              },
            ),
            SizedBox(height: 20),
            Text('Chọn sách:', style: TextStyle(fontSize: 16)),
            DropdownButton<String>(
              value: _sachDangChon,
              hint: Text('Chọn sách'),
              items: _danhSachSach
                  .map((sach) => DropdownMenuItem<String>(
                child: Text(sach),
                value: sach,
              ))
                  .toList(),
              onChanged: (value) {
                setState(() {
                  _sachDangChon = value;
                });
              },
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: _muonSach,
              child: Text('Mượn sách'),
            ),
            SizedBox(height: 30),
            Text('Lịch sử mượn sách:', style: TextStyle(fontSize: 16)),
            Expanded(
              child: ListView.builder(
                itemCount: _lichSuMuon.length,
                itemBuilder: (context, index) {
                  String nguoiDung = _dsNguoiDung[index];
                  List<String> sachDaMuon = _lichSuMuon[nguoiDung] ?? [];

                  return Card(
                    child: ListTile(
                      title: Text(nguoiDung),
                      subtitle: Text('Đã mượn: ${sachDaMuon.join(', ')}'),
                    ),
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
