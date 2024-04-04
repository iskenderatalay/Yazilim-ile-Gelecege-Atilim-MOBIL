import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(dataWidgets());
}

class dataWidgets extends StatefulWidget {
  const dataWidgets({super.key});

  @override
  State<dataWidgets> createState() => _dataWidgetsState();
}

class _dataWidgetsState extends State<dataWidgets> {
  int _secilenSayfaIndex = 0;
  String yazi = "";
  TextEditingController fieldController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Baslık'),
        ),
        body: Column(
          children: [
            TextField(
              controller: fieldController,
              style: TextStyle(
                color: Colors.white,
              ),
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                contentPadding: EdgeInsets.all(10),
                hintText: 'Bir seyler Yazın',
                filled: true,
                fillColor: Colors.deepPurple,
              ),
              autofocus: true,
              cursorColor: Colors.orange,
            ),
            ElevatedButton(
              onPressed: () {
                setState(() {
                  yazi = fieldController.text;
                });
              },
              child: Text('Aktar'),
            ),
            Text(
              yazi,
              style: TextStyle(fontSize: 25),
            )
          ],
        ),
        //Text('Secili olan : $_secilenSayfaIndex',style: TextStyle(fontSize: 25),),
        bottomNavigationBar: alttakiWidget(),
      ),
    );
  }

  Widget alttakiWidget() {
    return BottomNavigationBar(
      items: [
        BottomNavigationBarItem(
          icon: Icon(Icons.add_a_photo_outlined),
          label: 'Kamera',
        ),
        BottomNavigationBarItem(
          icon: Icon(Icons.add_alarm_outlined),
          label: 'Alarm',
        ),
        BottomNavigationBarItem(
          icon: Icon(Icons.add_call),
          label: 'Ara',
        ),
      ],
      currentIndex: _secilenSayfaIndex,
      onTap: _sayfaDegistir,
      elevation: 20,
      backgroundColor: Colors.blue,
      selectedItemColor: Colors.blue[900],
      unselectedItemColor: Colors.blue,
      iconSize: 30,
      showSelectedLabels: true,
      showUnselectedLabels: true,
      unselectedFontSize: 10,
      selectedFontSize: 16,
      type: BottomNavigationBarType.shifting,
    );
  }

  void _sayfaDegistir(int yeniIndex) {
    setState(() {
      _secilenSayfaIndex = yeniIndex;
    });
  }
}
