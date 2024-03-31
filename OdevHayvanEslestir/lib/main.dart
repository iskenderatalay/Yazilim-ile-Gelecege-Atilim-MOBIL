import 'dart:math';

import 'package:flutter/material.dart';
import 'package:odevhayvaneslestir/constants.dart';
import 'package:odevhayvaneslestir/hayvanData.dart';

void main() {
  runApp(animalPage());
}

class animalPage extends StatelessWidget {
  const animalPage({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          centerTitle: true,
          title: Text('Hayvan İsmi Bul'),
        ),
        body: pageDesign(),
      ),
    );
  }
}

class pageDesign extends StatefulWidget {
  const pageDesign({super.key});

  @override
  State<pageDesign> createState() => _pageDesignState();
}

class _pageDesignState extends State<pageDesign> {
  List<Widget> secimler = [];
  hayvanData hayvanlarObj = hayvanData();
  int rastgeleSayi = 0;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: [
        Expanded(
          flex: 3,
          child: Padding(
            padding: EdgeInsets.all(10),
            child: Center(
              child: Container(
                color: Colors.white,
                child: Image.asset(
                  hayvanlarObj.getHayvanResim(),
                ),
              ),
            ),
          ),
        ),
        Expanded(
          flex: 1,
          child: Center(
            child: Text(
              hayvanlarObj.getHayvanIsim(rastgeleSayi),
              style: TextStyle(fontSize: 30),
            ),
          ),
        ),
        Wrap(
          alignment: WrapAlignment.center,
          runSpacing: 3,
          spacing: 3,
          children: secimler,
        ),
        Expanded(
          flex: 1,
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Row(
              children: [
                Expanded(
                    child: Padding(
                  padding: EdgeInsets.symmetric(horizontal: 6),
                  child: TextButton(
                    style: ButtonStyle(
                      backgroundColor: MaterialStateProperty.all(Colors.red),
                    ),
                    child: Icon(
                      color: Colors.white,
                      Icons.thumb_down,
                      size: 35.0,
                    ),
                    onPressed: () {
                      setState(() {
                        rastgeleSayi == hayvanlarObj.sayfadakiHayvanIndex()
                            ? secimler.add(yanlisIcon)
                            : secimler.add(dogruIkon);

                        hayvanlarObj.sonrakiHayvan();
                        rastgeleSayi = Random().nextInt(5);
                      });
                    },
                  ),
                )),
                Expanded(
                    child: Padding(
                  padding: EdgeInsets.symmetric(horizontal: 6),
                  child: TextButton(
                    style: ButtonStyle(
                      backgroundColor: MaterialStateProperty.all(Colors.green),
                    ),
                    child: Icon(
                      color: Colors.white,
                      Icons.thumb_up,
                      size: 35.0,
                    ),
                    onPressed: () {
                      setState(() {
                        rastgeleSayi == hayvanlarObj.sayfadakiHayvanIndex()
                            ? secimler.add(dogruIkon)
                            : secimler.add(yanlisIcon);
                        hayvanlarObj.sonrakiHayvan();

                        rastgeleSayi = Random().nextInt(5);
                      });
                    },
                  ),
                )),
              ],
            ),
          ),
        )
      ],
    );
  }
}
