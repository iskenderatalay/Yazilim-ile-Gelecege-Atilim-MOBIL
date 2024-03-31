import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class OzelContainer extends StatelessWidget {
  final Widget child;
  final Color renk;

  OzelContainer({required this.child, this.renk = Colors.white});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: child,
      margin: EdgeInsets.all(12.0),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(10.0),
        color: renk,
      ),
    );
  }
}