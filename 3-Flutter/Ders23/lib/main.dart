import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

void main() {
  runApp(MaterialApp(
      theme: ThemeData(
        brightness: Brightness.light,
        primaryColor: Colors.cyan,
        scaffoldBackgroundColor: Colors.white,
        fontFamily: 'Georgia',
        textTheme: TextTheme(
          displayLarge: TextStyle(fontSize: 70, fontWeight: FontWeight.bold),
          titleLarge: TextStyle(fontSize: 40, fontStyle: FontStyle.italic),
          bodyMedium: TextStyle(fontSize: 25, fontFamily: 'Hind'),
        ),
      ),
      home: temaOlustur()));
}

class temaOlustur extends StatelessWidget {
  String data = "Hüseyin Bodur";

  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Tema Örneği'),
        backgroundColor: Colors.deepPurple,
      ),
      body: Container(
        child: Center(
          child: TextButton(
            onPressed: () {
              Navigator.push(
                  context,
                  MaterialPageRoute(
                      builder: (context) => Sayfa2(anahtar: data)));
            },
            child: Text('Sayfa 2 ye git'),
            style: TextButton.styleFrom(
              foregroundColor: Colors.white,
              elevation: 40,
              backgroundColor: Colors.green,
            ),
          ),
        ),
      ),
    );
  }
}

class Sayfa2 extends StatelessWidget {
  String anahtar;

  Sayfa2({this.anahtar = "merhaba"});

  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Sayfa 2'),
        backgroundColor: Colors.deepPurple,
      ),
      body: Center(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: <Widget>[
            Text(
              '$anahtar',
              style: TextStyle(fontSize: 30, color: Colors.black),
            ),
            TextButton(
              onPressed: () {
                Navigator.pop(context);
              },
              child: Text(
                'Geri Dön',
              ),
              style: TextButton.styleFrom(
                foregroundColor: Colors.white,
                elevation: 40,
                backgroundColor: Colors.green,
              ),
            ),
            TextButton(
              onPressed: () {
                Navigator.push(
                    context, MaterialPageRoute(builder: (context) => Sayfa3()));
              },
              child: Text(
                'Sayfa 3 e git',
              ),
              style: TextButton.styleFrom(
                foregroundColor: Colors.white,
                elevation: 40,
                backgroundColor: Colors.green,
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class Sayfa3 extends StatelessWidget {
  const Sayfa3({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Sayfa 3'),
        backgroundColor: Colors.deepPurple,
      ),
      body: sharedOrnek(),
    );
  }
}

class sharedOrnek extends StatefulWidget {
  const sharedOrnek({Key? key}) : super(key: key);

  @override
  State<sharedOrnek> createState() => _sharedOrnekState();
}

class _sharedOrnekState extends State<sharedOrnek> {
  int sayacDeger = 0;

  Future<void> veriKaydet() async {
    var sharedPreferences = await SharedPreferences.getInstance();
    sayacDeger++;
    sharedPreferences.setInt("sayac", sayacDeger);
  }

  Future<void> veriOku() async {
    var sharedPreferences = await SharedPreferences.getInstance();
    sayacDeger = sharedPreferences.getInt("sayac") ?? 0;
    setState(() {});
  }

  @override
  void initState() {
    super.initState();
    veriOku();
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        children: [
          Text('Sayaç:$sayacDeger'),
          TextButton(
            onPressed: () {
              setState(() {
                veriKaydet();
              });
            },
            child: Text(
              'Sayaç Arttır',
            ),
            style: TextButton.styleFrom(
                foregroundColor: Colors.white,
                backgroundColor: Colors.green,
                elevation: 40),
          ),
          TextButton(
            child: Text('Geri Dön'),
            onPressed: () {
              Navigator.pop(context);
            },
            style: TextButton.styleFrom(
                foregroundColor: Colors.white,
                backgroundColor: Colors.green,
                elevation: 40),
          ),
        ],
      ),
    );
  }
}
