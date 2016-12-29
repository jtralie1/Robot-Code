package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by UDRI1 on 9/27/2016.
 */
public class ServoOp extends OpMode{
    Servo open;
    Servo close;

    @Override
    public void init(){

        open = hardwareMap.servo.get("servo_open");
        close = hardwareMap.servo.get("servo_close");
    }

    public void loop(){

        boolean isClose = gamepad1.a;
        boolean isOpen = gamepad1.x;

            while(isOpen){
                open.setPosition(100);
        }



        while(isClose){
            close.setPosition(0);
        }
    }

}
