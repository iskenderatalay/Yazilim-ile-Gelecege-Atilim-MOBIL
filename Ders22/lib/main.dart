import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  //runApp(ozelFont());
  //runApp(rastgeleSayiUret());
  runApp(ekran());
}

class ozelFont extends StatelessWidget {
  const ozelFont({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(fontFamily: 'Alkatra'),
      home: Scaffold(
        body: SafeArea(
          child: Text(
            'Merhaba Dünya',
            //style: TextStyle(fontFamily: 'Alkatra', fontSize: 50),
          ),
        ),
      ),
    );
  }
}

class rastgeleSayiUret extends StatelessWidget {
  const rastgeleSayiUret({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.blueAccent,
          title: Text('Rastgele Sayi Üret',
              style: TextStyle(
                  color: Colors.white, fontSize: 25, fontFamily: 'Alkatra')),
        ),
        body: rastgele(),
      ),
    );
  }
}

class rastgele extends StatefulWidget {
  const rastgele({super.key});

  @override
  State<rastgele> createState() => _rastgeleState();
}

class _rastgeleState extends State<rastgele> {
  int uretilenSayi = 0;

  void sayiUret() {
    setState(() {
      uretilenSayi = Random().nextInt(100);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        children: <Widget>[
          Padding(
            padding: const EdgeInsets.all(50.0),
            child: TextButton(
                style: ButtonStyle(
                    backgroundColor: MaterialStateProperty.all(Colors.amber)),
                onPressed: sayiUret,
                child: Text('Sayi Uret',
                    style: TextStyle(fontSize: 30, color: Colors.blue))),
          ),
          Text('$uretilenSayi',
              style: TextStyle(fontSize: 150, fontWeight: FontWeight.bold))
        ],
      ),
    );
  }
}

class ekran extends StatelessWidget {
  const ekran({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Buton Rengi Değiştir'),
        ),
        body: ekranIslem(),
      ),
    );
  }
}

class ekranIslem extends StatefulWidget {
  const ekranIslem({super.key});

  @override
  State<ekranIslem> createState() => _ekranIslemState();
}

class _ekranIslemState extends State<ekranIslem> {
  String secilenButon = "Sol";

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(50.0),
      child: Center(
        child: Row(
          children: <Widget>[
            TextButton(
                onPressed: () {
                  setState(() {
                    secilenButon = "Sol";
                  });
                },
                child: Container(
                    width: 150,
                    height: 300,
                    color: secilenButon == 'Sol' ? Colors.blueAccent : Colors.blueGrey)),
            TextButton(
                onPressed: () {
                  setState(() {
                    secilenButon = "Sag";
                  });
                },
                child: Container(
                    width: 150,
                    height: 300,
                    color: secilenButon == 'Sag' ? Colors.blueAccent : Colors.blueGrey))
          ],
        ),
      ),
    );
  }
}