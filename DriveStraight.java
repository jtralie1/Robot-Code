package com.qualcomm.robotcore.eventloop.opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.LegacyModule;
/**
 * Created by UDRI1 on 11/16/2016.
 */

@Autonomous(name = "Auto1", group = "Test")
public class DriveStraight extends OpMode{

    DcMotor lb;
    DcMotor rb;
    DcMotor lf;
    DcMotor rf;
    int count = 1;

    public void init(){

        long time = System.currentTimeMillis();
        long end = time + 5000;
        while(System.currentTimeMillis() < end){

            lb.setPower(1);
            rb.setPower(1);
            lf.setPower(1);
            rf.setPower(1);
            try{Thread.sleep(200);}
            catch(InterruptedException e){e.printStackTrace();}

        }

    }

    public void loop() {



    }

}

