package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AccelerationSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.GyroSensor;
import java.sql.Timestamp;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_TO_POSITION;
import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.STOP_AND_RESET_ENCODER;
import static com.qualcomm.robotcore.hardware.DcMotorController.*;

/**
 * Created by UDRI1 on 11/16/2016.
 */

@Autonomous (name = "Auto2", group = "Test")
public class Auto2 extends LinearOpMode {

    // 7 declare motors, 3 servos, 1 gyro, 2 color sensors
    DcMotor lfmotor;
    DcMotor rfmotor;
    DcMotor lbmotor;
    DcMotor rbmotor;
    DcMotor shooterLeft;
    DcMotor shooterRight;
    DcMotor intakeMotor;
    Servo door;
    Servo lift;
    Servo buttonPusher;
    GyroSensor gyro;
    ColorSensor wallCS;
    //ColorSensor floorCS;

    //use to convert RGB to HSV
    float hsvValues[] = {0F,0F,0F};
    final float values[] = hsvValues;

    //ourColor will be set by user input
    static boolean colorSet, buttonHit;
    static String ourColor;


    public void runOpMode() {
        //initialize parts:
        //test = hardwareMap.servo.get("dsad");
        gyro = hardwareMap.gyroSensor.get("gyro");
        wallCS = hardwareMap.colorSensor.get("csWall");
        //floorCS = hardwareMap.colorSensor.get("csFloor");

        for (int i = 0; i < 1000; i++) {
            gyro.calibrate();
        }
        lfmotor = hardwareMap.dcMotor.get("left_front_motor");
        rfmotor = hardwareMap.dcMotor.get("right_front_motor");
        rbmotor = hardwareMap.dcMotor.get("right_back_motor");
        lbmotor = hardwareMap.dcMotor.get("left_back_motor");
        shooterLeft = hardwareMap.dcMotor.get("intake_l");
        shooterRight = hardwareMap.dcMotor.get("intake_r");
        door = hardwareMap.servo.get("door");
        lift = hardwareMap.servo.get("lift");
        intakeMotor = hardwareMap.dcMotor.get("intake");
        buttonPusher = hardwareMap.servo.get("buttonz");
        buttonPusher.setPosition(0);
        telemetry.addData("Waiting", 1);
        telemetry.update();

        //user input color: dpad down = red, dpad up = blue
        ourColor = null;
        colorSet = false;
        while (colorSet == false){

            if(gamepad1.dpad_down == true){
                ourColor = "red";
                colorSet = true;
            }
            if (gamepad1.dpad_up == true){
                ourColor = "blue";
                colorSet = true;
            }

            telemetry.addData("Searching for color... red status -- down)", gamepad1.dpad_down);
            telemetry.addData("blue status -- up", gamepad1.dpad_up);
            telemetry.update();
        }

        //user presses start (make sure 2 balls are loaded)
        waitForStart();

        //prep: brake, callibrate, close door
        for (int i = 0; i < 1000; i++) {
            brake(0);
            gyro.calibrate();
            door.setPosition(.55);
        }

        //drive straight (distance needs to be set based on robot)
        for (int i = 0; i < 20000; i++) {
            goForward(0);
        }

        //shoot ball 2: break motors, turn on shooting motors, raise lift
        for (int i = 0; i < 20000; i++) {
            brake(0);
            shooterLeft.setPower(-1);
            shooterRight.setPower(1);
            lift.setPosition(.95);
        }

        //reset: turn off shooting motors, set lift back to 0, open door
        for (int i = 0; i <20000; i++){
            shooterLeft.setPower(0);
            shooterRight.setPower(0);
            lift.setPosition(0);
            door.setPosition(0);
        }

        //give it some time... take out if don't need
        sleep(200000);

        //turn on intake to scoop next ball into shooting position
        for (int i = 0; i<20000; i++){
            intakeMotor.setPower(1);
        }

        //Prep: close door
        for (int i = 0; i <20000; i++){
            door.setPosition(.55);
        }

        //shoot ball 2: turn on shooting motors, raise lift
        for (int i = 0; i < 20000; i++) {
            shooterLeft.setPower(-1);
            shooterRight.setPower(1);
            lift.setPosition(.95);
        }

        //reset: turn off shooting motors, set lift back to 0, open door
        for (int i = 0; i <20000; i++){
            shooterLeft.setPower(0);
            shooterRight.setPower(0);
            lift.setPosition(0);
            door.setPosition(0);
        }

        //rotate +90°
        for (int i = 0; i < 20000; i++) {
            turnRight();
        }

        //brake
        for (int i = 0; i < 20000; i++) {
            brake(0);
        }

        // go forward (fix distance to wall)
        for (int i = 0; i < 20000; i++) {
           goForward(0);
        }

        //brake
        for (int i = 0; i < 20000; i++) {
            brake(0);
        }

        //rotate -90°
        for (int i = 0; i < 20000; i++) {
            turnLeft();
        }

        //brake
        for (int i = 0; i < 20000; i++) {
            brake(0);
        }

        //IN TESTING STAGE: use floor light sensor to line up with button
        for (int i = 0; i < 2000; i++) {
            goForward(0);
        }


        boolean linedUp = false;

       /* for (int i = 0; i < 20000; i++) {
            if(!linedUp){
                goBackward(0);
                if (cs1.alpha() > 8000 && cs1.alpha() < 1000) {
                linedUp = true;
                }
            }
            telemetry.addData("Floor Alpha", cs1.alpha());
            telemetry.addData("Lined Up?", linedUp);
            telemetry.update();
        }*/

      /* while (cs2.red()== 0 && cs2.blue()== 0){
            strafeRight();
        }
        if(cs2.red()>0 && cs2.blue() == 0){
            for (int i = 0; i<100; i++)
                if(cs2.red()>0 && cs2.blue() == 0)
                    strafeRight();
            for (int i = 0; i<100; i++)
                strafeLeft();
            for (int i = 0; i<100; i++)
                goForward(0);
        }
        else if (cs2.red()==0 && cs2.blue() > 0){
            for (int i = 0; i<100; i++)
                goForward(0);
            for (int i = 0; i<100; i++)
                if(cs2.red()>0 && cs2.blue() == 0)
                    strafeRight();
            for (int i = 0; i<100; i++)
                strafeLeft();
        }

        for (int i = 0; i < 20000; i++) {
            goForward(0);
            telemetry.addData("forward 1: ", i);
            telemetry.update();
        }

        while (cs2.red()== 0 && cs2.blue()== 0){
            strafeRight();
        }
        if(cs2.red()>0 && cs2.blue() == 0){
            for (int i = 0; i<100; i++)
                if(cs2.red()>0 && cs2.blue() == 0)
                    strafeRight();
            for (int i = 0; i<100; i++)
                strafeLeft();
            for (int i = 0; i<100; i++)
                goForward(0);
        }
        else if (cs2.red()==0 && cs2.blue() > 0){
            for (int i = 0; i<100; i++)
                goForward(0);
            for (int i = 0; i<100; i++)
                if(cs2.red()>0 && cs2.blue() == 0)
                    strafeRight();
            for (int i = 0; i<100; i++)
                strafeLeft();
        }

        /*while (!linedUp) {
            if (cs1.alpha() > 5 && cs1.alpha() < 20) {
                linedUp = true;
            } else {
                for (int i = 0; i < 200; i++) {
                    goForward(0);
                    if (cs1.alpha() > 5 && cs1.alpha() < 20) {
                        linedUp = true;
                        break;
                    }

                }
            }*//*






       /* for(int i = 0; i < 20000; i++){
            goForward(0);
            telemetry.addData("Go forward: ", i);
            telemetry.update();
        }

        for(int i = 0; i < 20000; i++){
            telemetry.addData("backward: ", "running");
            telemetry.update();
            goBackward(0);}

        for(int i = 0; i < 20000; i++){
            telemetry.addData("strafe: ", "running");
            telemetry.update();
            strafeLeft();}*/


            brake(0);

        }


    public void goBackward (int wantedInt){
        lfmotor.setPower(1);
        rfmotor.setPower(-1);
        lbmotor.setPower(1);
        rbmotor.setPower(-1);
        telemetry.addData("Going Backward, Heading:", gyro.getHeading());
        telemetry.update();
    }
    public void goForward(int wantedAngle){
        lfmotor.setPower(-1);
        rfmotor.setPower(1);
        lbmotor.setPower(-1);
        rbmotor.setPower(1);

        telemetry.addData("Going Forward, Heading:", gyro.getHeading());
        telemetry.update();
          /*  if(gyro.getHeading()>wantedAngle) {
                lfmotor.setPower(-.99);
                lbmotor.setPower(-.99);
            }
            if(gyro.getHeading()<wantedAngle) {
                rfmotor.setPower(.99);
                rbmotor.setPower(.99);*/
    }


    public void turnRight(){
        lfmotor.setPower(-1);
        rfmotor.setPower(-1);
        lbmotor.setPower(-1);
        rbmotor.setPower(-1);
    }

    public void turnLeft(){
        int k=1;
        telemetry.addData ("Programming turning left:",k);
        //while(gyro.getHeading()<5 || gyro.getHeading()> 360-angle) {

        lfmotor.setPower(0.5);
        rfmotor.setPower(0.5);
        lbmotor.setPower(0.5);
        rbmotor.setPower(0.5);
        telemetry.addData("Heading:", gyro.getHeading());

        //}
    }

    public void strafeRight(){

        lbmotor.setPower(-1);
        lfmotor.setPower(1);
        rbmotor.setPower(1);
        rfmotor.setPower(-1);

        telemetry.addData("In strafe, Heading:", gyro.getHeading());
        telemetry.update();

    }

    public void strafeLeft(){

        rfmotor.setPower(1);
        rbmotor.setPower(-1);
        lfmotor.setPower(-1);
        lbmotor.setPower(1);
    }

    public void brake(int wantedInt){
        lfmotor.setPower(0);
        rfmotor.setPower(0);
        lbmotor.setPower(0);
        rbmotor.setPower(0);
    }

    public void setShooterMode(int shoot)
    {
        shooterRight.setPower(shoot);
        shooterLeft.setPower(shoot);
    }
}










       /*for(int i = 0; i<10; i++){
            lfmotor.setPower(1);
            rfmotor.setPower(-1);
            lbmotor.setPower(1);
            rbmotor.setPower(-1);
            rotations = rbmotor.getCurrentPosition();
            telemetry.addData("Rotations: ", + rotations);
            telemetry.addData("I: ", + i);
        }
        lfmotor.setPower(0);
        rfmotor.setPower(0);
        lbmotor.setPower(0);
        rbmotor.setPower(0);
    /*    rf = rotations;
        while (rotations < rf-2000) {
            lfmotor.setPower(1);
            rfmotor.setPower(-1);
            lbmotor.setPower(1);
            rbmotor.setPower(-1);
            rotations = rfmotor.getCurrentPosition();
            telemetry.addData("Rotations: ", rotations);
        } *//*
    }


}


//IM A FAILURE
// I agree - David
//FU
//YAY FUN TIMEZ

  /*   public void start() {
            boolean a = true;
            while (a) {
            telemetry.addData("current pos: ", rfmotor.getCurrentPosition());
            rfmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            if (step == 0) {
                while (rotations < 5000) {
                    //5000r = 87 ft
                    lfmotor.setPower(-1);
                    rfmotor.setPower(1);
                    lbmotor.setPower(-1);
                    rbmotor.setPower(1);
                    rotations = rfmotor.getCurrentPosition();
                    telemetry.addData("Rotations: ", rotations);
                }
                rf = rotations;
                step = 1;
                break;
            } else if (step == 1) {
                while (rotations < rf-2000) {
                    lfmotor.setPower(1);
                    rfmotor.setPower(-1);
                    lbmotor.setPower(1);
                    rbmotor.setPower(-1);
                    rotations = rfmotor.getCurrentPosition();
                    telemetry.addData("Rotations: ", rotations);
                }
                rf = rotations;
                step = 2;
                break;
            } else if (step == 2) {
                while (rotations < rf-3000) {
                    //2000 = 90 degrees
                    lfmotor.setPower(-1);
                    rfmotor.setPower(-1);
                    lbmotor.setPower(-1);
                    rbmotor.setPower(-1);
                    rotations = rfmotor.getCurrentPosition();
                }
                rf = rotations;
                step = 3;
                break;
            } else {
                a = false;
                stop();
            }
            rf = rotations;
            lfmotor.setPower(0);
            rfmotor.setPower(0);
            lbmotor.setPower(0);
            rbmotor.setPower(0);
            //rfmotor.setMode(STOP_AND_RESET_ENCODER);
        }
        }*/
  /*  rfmotor.setTargetPosition (2000);
        rfmotor.setMode (RUN_TO_POSITION);
        while(rfmotor.getCurrentPosition()< 2000){
            lfmotor.setPower(-1);
           // rfmotor.setPower(1);
            lbmotor.setPower(-1);
            rbmotor.setPower(1);
        }*/