import 'package:flutter/material.dart';

void main() {
  runApp(dataWidgets());
}

class dataWidgets extends StatelessWidget {
  const dataWidgets({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Widgetlar'),
          backgroundColor: Colors.cyan,
        ),
        body: radioWidget(),
        //checkboxWidget(),
        //dataWidgetBody(),
        //Text('Merhaba Dünya',style: TextStyle(fontSize: 40),),
        drawer: _buildDrawer(context),
      ),
    );
  }
}

class dataWidgetBody extends StatefulWidget {
  const dataWidgetBody({super.key});

  @override
  State<dataWidgetBody> createState() => _dataWidgetBodyState();
}

class _dataWidgetBodyState extends State<dataWidgetBody> {
  bool durum = false;

  void durumDegistir(bool yeniDurum) {
    setState(() {
      durum = yeniDurum;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Switch(
            activeColor: Colors.pink,
            inactiveThumbColor: Colors.black,
            activeTrackColor: Colors.lightBlue,
            inactiveTrackColor: Colors.brown,
            value: durum,
            onChanged: durumDegistir),
        SizedBox(
          height: 10,
        ),
        Text(
          'Switchin Durumu: $durum',
          style: TextStyle(fontSize: 35),
        ),
      ],
    );
  }
}

class checkboxWidget extends StatefulWidget {
  const checkboxWidget({super.key});

  @override
  State<checkboxWidget> createState() => _checkboxWidgetState();
}

class _checkboxWidgetState extends State<checkboxWidget> {
  bool java = false,
      csharp = false,
      php = false;

  String bilinenDiller() {
    String diller = "";
    if (java == true) diller += "Java, ";
    if (csharp == true) diller += "Csharp, ";
    if (php == true) diller += "Php ";
    return diller;
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Text(
          'Bildiğiniz Programlama Dilleri:',
          style: TextStyle(fontSize: 25),
        ),
        CheckboxListTile(
          title: Text(
            "Java",
            style: TextStyle(fontSize: 25),
          ),
          value: java,
          onChanged: (bool? newValue) {
            setState(() {
              java = newValue!;
            });
          },
        ),
        SizedBox(
          height: 20,
        ),
        CheckboxListTile(
          title: Text(
            "Csharp",
            style: TextStyle(fontSize: 25),
          ),
          value: csharp,
          onChanged: (bool? newValue) {
            setState(() {
              csharp = newValue!;
            });
          },
        ),
        SizedBox(
          height: 20,
        ),
        CheckboxListTile(
          title: Text(
            "Php",
            style: TextStyle(fontSize: 25),
          ),
          value: php,
          onChanged: (bool? newValue) {
            setState(() {
              php = newValue!;
            });
          },
        ),
        Text(
          'Diller : ' + bilinenDiller(),
          style: TextStyle(fontSize: 25),
        ),
      ],
    );
  }
}

class radioWidget extends StatefulWidget {
  const radioWidget({super.key});

  @override
  State<radioWidget> createState() => _radioWidgetState();
}

class _radioWidgetState extends State<radioWidget> {
  String secilenTakim = "";

  void secilenTakimDegistir(String? yeniTakim) {
    setState(() {
      secilenTakim = yeniTakim!;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        children: [
          Text(
            'Hangi takımı tutuyorsun?',
            style: TextStyle(fontSize: 25),
          ),
          RadioListTile(
            title: Text(
              'Fenerbahce',
              style: TextStyle(fontSize: 25),
            ),
            value: 'Fenerbahce',
            groupValue: secilenTakim,
            onChanged: secilenTakimDegistir,
            activeColor: Colors.blue[800],
          ),
          RadioListTile(
            title: Text(
              'Galatasaray',
              style: TextStyle(fontSize: 25),
            ),
            value: 'Galatasaray',
            groupValue: secilenTakim,
            onChanged: secilenTakimDegistir,
            activeColor: Colors.orange,
          ),
          RadioListTile(
            title: Text(
              'Besiktaş',
              style: TextStyle(fontSize: 25),
            ),
            value: 'Besiktas',
            groupValue: secilenTakim,
            onChanged: secilenTakimDegistir,
            activeColor: Colors.black,
          ),
          Text(
            'Secilen Takim: $secilenTakim',
            style: TextStyle(fontSize: 25),
          )
        ],
      ),
    );
  }
}

Widget _buildDrawer(BuildContext context) {
  return Drawer(
    child: ListView(
      children: [
        UserAccountsDrawerHeader(
          currentAccountPicture: FlutterLogo(),
          accountName: Text('Hüseyin Bodur', style: TextStyle(fontSize: 25)),
          accountEmail: Text('huseyin@email.com'),
          decoration: BoxDecoration(color: Colors.red),
        ),
        ListTile(title: Text('Kitaplar'),
          subtitle: Text('Detaylar için tıkla'),
          leading: Icon(Icons.book, color: Colors.amber),
          trailing: Icon(Icons.ac_unit),
          onTap: () {
            Navigator.pop(context);
          },
        ),
        ListTile(title: Text('Makaleler'),
          subtitle: Text('Akademik Çalışmalar'),
          leading: Icon(Icons.book_online, color: Colors.blue),
          trailing: Icon(Icons.accessibility_new,color: Colors.brown,),
          onTap: () {
            Navigator.pop(context);
          },
        ),
      ],
    ),
  );
}