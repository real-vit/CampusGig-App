import 'package:flutter/material.dart';
import 'package:login_page_1/ui/screens/login_screen.dart';
import 'package:login_page_1/ui/screens/sing_up_screen.dart';
import 'package:login_page_1/ui/screens/verify_screen.dart';
import 'package:login_page_1/ui/screens/welcomescreen.dart';
import 'package:login_page_1/ui/screens/master.dart';

class MainView extends StatefulWidget {
  const MainView({super.key});

  @override
  State<MainView> createState() => _MainViewState();
}

class _MainViewState extends State<MainView> {
  PageController controller = PageController(initialPage: 0);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: PageView.builder(
        physics: const NeverScrollableScrollPhysics(),
        itemCount: 5,
        controller: controller,
        itemBuilder: (context, index)
        {
          if(index==0)
            {
              return WelcomeScreen(
                controller: controller,
              );
            }
         else if (index == 1) {
            return LoginScreen(
              controller: controller,
            );
          } else if (index == 2) {
            return SignUpScreen(
              controller: controller,
            );
          } else if (index == 3){
        return VerifyScreen(
        controller: controller,
        );
        }
         else
         {
           return MasterScreen(
         controller: controller,
           );
              }
          }

      ),
    );
  }
}
