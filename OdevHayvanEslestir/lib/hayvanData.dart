import 'hayvan.dart';
class hayvanData{
  int _hayvanIndex = 0;
  List<Hayvan> _hayvanlar =[
    Hayvan(hayvanResim: 'images/aslan.png', hayvanIsim: 'Aslan'),
    Hayvan(hayvanResim: 'images/fil.png', hayvanIsim: 'Fil'),
    Hayvan(hayvanResim: 'images/kus.png', hayvanIsim: 'Kus'),
    Hayvan(hayvanResim: 'images/yilan.png', hayvanIsim: 'Yilan'),
    Hayvan(hayvanResim: 'images/zurafa.png', hayvanIsim: 'Zurafa')
  ];
  String getHayvanResim(){
    return _hayvanlar[_hayvanIndex].hayvanResim;
  }
  String getHayvanIsim(int index){
    return _hayvanlar[index].hayvanIsim;
  }
  void sonrakiHayvan(){
    if(_hayvanIndex < _hayvanlar.length - 1)
      _hayvanIndex++;
    else
      _hayvanIndex = 0;
  }
  int sayfadakiHayvanIndex(){
    return _hayvanIndex;
  }
}