import 'package:flutter/material.dart';

void main() {
  runApp(
    //body()
    //resimGoster()
    //containerOrnek()
    //columnKullanim(),
    rowKullanim(),
  );
}

class body extends StatelessWidget {
  const body({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Mobil Sayfam'),
          backgroundColor: Colors.amber,
        ),
        body: Center(
          child: Text(
            'Merhaba Dünya',
            style: TextStyle(
                fontSize: 50,
                color: Colors.blueAccent,
                fontWeight: FontWeight.bold),
          ),
        ),
      ),
    );
  }
}

class resimGoster extends StatelessWidget {
  const resimGoster({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Resim'),
          backgroundColor: Colors.blueAccent,
        ),
        body: SafeArea(
          child: Image.asset("images/xz.png"),
        ),
      ),
    );
  }
}

class containerOrnek extends StatelessWidget {
  const containerOrnek({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Container(
          //margin: EdgeInsets.only(left: 40, top: 20, right: 15),
          margin: EdgeInsets.symmetric(vertical: 250, horizontal: 100),
          padding: EdgeInsets.all(10.0),
          width: 200,
          height: 300,
          alignment: Alignment.bottomRight,
          //color: Colors.deepOrange,
          decoration: BoxDecoration(
            shape: BoxShape.rectangle,
            color: Colors.blue,
            borderRadius: BorderRadiusDirectional.circular(20.0),
          ),
          child: Text(
            "Hi",
            style: TextStyle(fontSize: 20, color: Colors.yellow),
          ),
        ),
      ),
    );
  }
}

class columnKullanim extends StatelessWidget {
  const columnKullanim({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: SafeArea(
          child: Column(
            //mainAxisAlignment: MainAxisAlignment.spaceBetween,
            //verticalDirection: VerticalDirection.up,
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: <Widget>[
              Container(
                color: Colors.brown,
                width: 150,
                height: 75,
                child: Text(
                  'Container 1',
                  style: TextStyle(color: Colors.white, fontSize: 25),
                ),
              ),
              SizedBox(
                height: 20,
              ),
              Container(
                color: Colors.blue,
                width: 150,
                height: 75,
                child: Text(
                  'Container 2',
                  style: TextStyle(color: Colors.white, fontSize: 25),
                ),
              ),
              SizedBox(
                height: 20,
              ),
              Container(
                color: Colors.cyan,
                width: 150,
                height: 75,
                child: Text(
                  'Container 3',
                  style: TextStyle(color: Colors.white, fontSize: 25),
                ),
              ),
              SizedBox(
                height: 20,
              ),
              Container(
                color: Colors.deepOrange,
                width: 150,
                height: 75,
                child: Text(
                  'Container 4',
                  style: TextStyle(color: Colors.white, fontSize: 25),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class rowKullanim extends StatelessWidget {
  const rowKullanim({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: SafeArea(
          child: Row(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: <Widget>[
              Container(
                color: Colors.deepOrange,
                child: Text('Row 1'),
              ),
              SizedBox(width: 20,),
              Container(
                color: Colors.cyan,
                child: Text('Row 2'),
              ),
              SizedBox(width: 20,),
              Container(
                color: Colors.amber,
                child: Text('Row 3'),
              ),
              SizedBox(width: 20,),
              Column(children: <Widget>[
                Container(
                  color: Colors.teal,
                  child: Text('Row 4'),
                  height: 200,
                ),
                SizedBox(height: 20,),
                Container(
                  color: Colors.deepPurple,
                  child: Text('Row 5'),
                  height: 100,
                ),
              ],)
            ],
          ),
        ),
      ),
    );
  }
}
