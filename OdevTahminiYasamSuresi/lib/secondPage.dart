import 'package:flutter/material.dart';
import 'constants.dart';
import 'userData.dart';

class secondPage extends StatelessWidget {
  final UserData _userData;
  secondPage(this._userData);

  int beklenenYasamSuresi() {
    double sonuc;
    sonuc = 60 + (_userData.sporGun * 2) - (_userData.icilenSigara * 0.2);
    sonuc += _userData.boy / _userData.kilo;
    if (_userData.secilenCinsiyet == 'Kadın') sonuc += 3;
    return sonuc.round();
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Sonuç Sayfası'),
        ),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Center(
              child: Text(
                'Beklenen Yaşam Süresi:${beklenenYasamSuresi().toString()}',
                style: kMetinStyle,
              ),
            ),
          ],
        ));
  }
}
