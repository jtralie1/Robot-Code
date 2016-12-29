package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AccelerationSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by UDRI1 on 11/22/2016.
 */

@Autonomous(name = "completeAuto", group = "Test")

public class completeAuto extends LinearOpMode
{
    //GyroSensor gyro;
    //AccelerationSensor accelerometer;
   // Servo buttonPusher;
   // ColorSensor eye;

    DcMotor lfmotor;
    DcMotor rfmotor;
    DcMotor lbmotor;
    DcMotor rbmotor;

   // long timeNow;
   // long timeElapsed;

  // public void strafeRight(){
        //rfmotor.setPower(1);
        //rbmotor.setPower(-1);
       // lfmotor.setPower(1);
       // lbmotor.setPower(-1);
  //  }



       // while(gyro.getHeading()>1) {
           // lfmotor.setPower(-.9);
            //lbmotor.setPower(-.9);
        //}
        //while(gyro.getHeading()<-1) {
            //rfmotor.setPower(.9);
            //rbmotor.setPower(.9);
        //}


    public void runOpMode() throws InterruptedException
    {
        waitForStart();
        lfmotor = hardwareMap.dcMotor.get("left_front_motor");
        rfmotor = hardwareMap.dcMotor.get("right_front_motor");
        lbmotor = hardwareMap.dcMotor.get("left_back_motor");
        rbmotor = hardwareMap.dcMotor.get("right_back_motor");
       int x = 0;
        while(x <= 100000) {
            goForward();
            x++;
        }
        //gyro.calibrate();
        //accelerometer.getAcceleration();
        //auto2.setShooterMode(1);

        //robot must drive forward, then strafe left and push button, then strafe right and go forward
        //turn 90 degrees, push button
        /*
        timeNow = System.currentTimeMillis();
        timeElapsed = timeNow + 2000;

        while(timeElapsed != timeNow) {
            goForward();
            timeElapsed--;
        }

        timeElapsed = System.currentTimeMillis() + 2000;
        while(timeElapsed != timeNow)
        {
            strafeRight();
            timeElapsed--;
        }

        timeElapsed = System.currentTimeMillis() + 2000;
        while(timeElapsed != timeNow)
        {
            goForward();
            timeElapsed--;
        }

        //checkButton();

        timeElapsed = System.currentTimeMillis() + 2000;
        while(timeElapsed != timeNow)
        {
            goForward();
            timeElapsed--;
        }

        //checkButton();

    }




    void checkButton()
    {
        if(eye.equals(eye.blue()))
        {
            pushButton();
        }
        else if(eye.equals(eye.red()))
        {
            //need to know if we need to push other button
        }
    }

    void pushButton()
    {

        timeElapsed = System.currentTimeMillis() + 1000;
        while(timeElapsed != timeNow)
        {
            buttonPusher.setPosition(1);
            timeElapsed--;
        }

        timeElapsed = System.currentTimeMillis() + 1000;
        while(timeElapsed != timeNow)
        {
            buttonPusher.setPosition(0);
            timeElapsed--;
        }

        buttonPusher.setPosition(0.5);
*/
    }

    public void goForward() {
        lfmotor.setPower(-1);
        rfmotor.setPower(1);
        lbmotor.setPower(-1);
        rbmotor.setPower(1);
    }
}
