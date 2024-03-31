import 'package:flutter/material.dart';
import 'package:odevtahminiyasamsuresi/userData.dart';
import 'ozelContainer.dart';
import 'iconText.dart';
import 'constants.dart';
import 'secondPage.dart';

void main() {
  runApp(const saglikliYasam());
}

class saglikliYasam extends StatelessWidget {
  const saglikliYasam({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
          scaffoldBackgroundColor: Colors.lightBlue,
          primaryColor: Colors.lightBlue),
      home: Scaffold(
        appBar: AppBar(title: Text('Sağlıklı Yaşam')),
        body: bodyYapisi(),
      ),
    );
  }
}

class bodyYapisi extends StatefulWidget {
  const bodyYapisi({super.key});

  @override
  State<bodyYapisi> createState() => _bodyYapisiState();
}

class _bodyYapisiState extends State<bodyYapisi> {
  String secilenCinsiyet = 'Kadın';
  double icilenSigara = 0.0;
  double sporGun = 0.0;
  int boy = 170;
  int kilo = 102;

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: [
        Expanded(
          child: Row(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: <Widget>[
              Expanded(
                child: OzelContainer(
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: <Widget>[
                      RotatedBox(
                        quarterTurns: 3,
                        child: Text(
                          'BOY',
                          style: kMetinStyle,
                        ),
                      ),
                      SizedBox(
                        width: 10,
                      ),
                      RotatedBox(
                        quarterTurns: 3,
                        child: Text(
                          '$boy',
                          style: kSayiStyle,
                        ),
                      ),
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: <Widget>[
                          SizedBox(
                            width: 50.0,
                            child: OutlinedButton(
                              style: OutlinedButton.styleFrom(
                                side: BorderSide(color: Colors.blue),
                              ),
                              onPressed: () {
                                setState(() {
                                  boy++;
                                });
                              },
                              child: Icon(
                                Icons.add,
                                size: 20,
                              ),
                            ),
                          ),
                          SizedBox(
                            width: 50.0,
                            child: OutlinedButton(
                              style: OutlinedButton.styleFrom(
                                side: BorderSide(color: Colors.blue),
                              ),
                              onPressed: () {
                                setState(() {
                                  boy--;
                                });
                              },
                              child: Icon(
                                Icons.remove,
                                size: 20,
                              ),
                            ),
                          ),
                        ],
                      )
                    ],
                  ),
                ),
              ),
              Expanded(
                child: OzelContainer(
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: <Widget>[
                      RotatedBox(
                        quarterTurns: 3,
                        child: Text(
                          'KİLO',
                          style: kMetinStyle,
                        ),
                      ),
                      SizedBox(
                        width: 10,
                      ),
                      RotatedBox(
                        quarterTurns: 3,
                        child: Text(
                          '$kilo',
                          style: kSayiStyle,
                        ),
                      ),
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: <Widget>[
                          SizedBox(
                            width: 50.0,
                            child: OutlinedButton(
                              style: OutlinedButton.styleFrom(
                                side: BorderSide(color: Colors.blue),
                              ),
                              onPressed: () {
                                setState(() {
                                  kilo++;
                                });
                              },
                              child: Icon(
                                Icons.add,
                                size: 20,
                              ),
                            ),
                          ),
                          SizedBox(
                            width: 50.0,
                            child: OutlinedButton(
                              style: OutlinedButton.styleFrom(
                                side: BorderSide(color: Colors.blue),
                              ),
                              onPressed: () {
                                setState(() {
                                  kilo--;
                                });
                              },
                              child: Icon(
                                Icons.remove,
                                size: 20,
                              ),
                            ),
                          ),
                        ],
                      )
                    ],
                  ),
                ),
              ),
            ],
          ),
        ),
        Expanded(
          child: OzelContainer(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  'Haftada Kaç Gün Spor Yapıyorsunuz?',
                  style: kMetinStyle,
                ),
                Text(
                  '${sporGun.round()}',
                  style: kSayiStyle,
                ),
                Slider(
                  min: 0,
                  max: 7,
                  divisions: 7,
                  value: sporGun,
                  onChanged: (double yeniDeger) {
                    setState(() {
                      sporGun = yeniDeger;
                    });
                  },
                ),
              ],
            ),
          ),
        ),
        Expanded(
          child: OzelContainer(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  'Günde Kaç Sigara İçiyorsunuz?',
                  style: kMetinStyle,
                ),
                Text(
                  '${icilenSigara.round()}',
                  style: kSayiStyle,
                ),
                Slider(
                  min: 0,
                  max: 30,
                  value: icilenSigara,
                  onChanged: (double yeniDeger) {
                    setState(() {
                      icilenSigara = yeniDeger;
                    });
                  },
                ),
              ],
            ),
          ),
        ),
        Expanded(
          child: Row(
            children: [
              Expanded(
                child: GestureDetector(
                  onTap: () {
                    setState(() {
                      secilenCinsiyet = 'Kadın';
                    });
                  },
                  child: OzelContainer(
                    renk: secilenCinsiyet == 'Kadın'
                        ? Colors.lightBlueAccent
                        : Colors.white,
                    child: IconText(
                      cinsiyet: 'KADIN',
                      icon: Icons.woman,
                    ),
                  ),
                ),
              ),
              Expanded(
                child: GestureDetector(
                  onTap: () {
                    setState(() {
                      secilenCinsiyet = 'Erkek';
                    });
                  },
                  child: OzelContainer(
                    renk: secilenCinsiyet == 'Erkek'
                        ? Colors.lightBlueAccent
                        : Colors.white,
                    child: IconText(
                      cinsiyet: 'ERKEK',
                      icon: Icons.man,
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
        Expanded(
            child: OzelContainer(
          child: TextButton(
            child: Text('Hesapla'),
            style: TextButton.styleFrom(
              textStyle: TextStyle(
                  color: Colors.white,
                  fontSize: 30,
                  backgroundColor: Colors.white),
            ),
            onPressed: () {
              UserData kullaniciVeriler = UserData(
                  secilenCinsiyet: secilenCinsiyet,
                  icilenSigara: icilenSigara,
                  sporGun: sporGun,
                  boy: boy,
                  kilo: kilo);
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => secondPage(kullaniciVeriler),
                ),
              );
            },
          ),
        ),
        ),
      ],
    );
  }
}
