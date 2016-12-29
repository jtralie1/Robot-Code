package org.firstinspires.ftc.teamcode;
        import com.qualcomm.hardware.hitechnic.HiTechnicNxtGyroSensor;
        import com.qualcomm.hardware.hitechnic.HiTechnicNxtLightSensor;
        import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.hardware.LegacyModule;
        import java.sql.Timestamp;
        import java.util.Calendar;

        import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by UDRI1 on 11/9/2016.
 */
@Autonomous(name = "Auto11", group = "Test")
public class Autonomous1 extends OpMode{
    HiTechnicNxtGyroSensor a;
    LegacyModule lm;
    int step = 1;
    Timestamp time1 =  new Timestamp(System.currentTimeMillis());
    Timestamp time2 = new Timestamp(System.currentTimeMillis());
    double bias;
    double sum;
    double deltaTime;
    double theta=0.0;
    Timestamp thingToGetTime;
    HiTechnicNxtLightSensor light;
    double max = 0;

    public void init() {
        lm = hardwareMap.legacyModule.get("AL00XPSZ");
        a = new HiTechnicNxtGyroSensor (lm,2);
        light = new HiTechnicNxtLightSensor(lm,1);
        step = 1;
        sum = 0;
}


    public void loop() {
        telemetry.addData ("RF:", a.getRotationFraction());
        if(a.getRotationFraction()>max){
            max = a.getRotationFraction();
        }
        telemetry.addData ("Max:", max);

        time2.setNanos(time1.getNanos());
        time1 = new Timestamp(System.currentTimeMillis());
        deltaTime = time1.getNanos() - time2.getNanos();
        double conversion = 1000000000;
        theta += 360*(a.getRotationFraction() - bias)*(deltaTime/conversion);
        telemetry.addData ("RF - bias:", a.getRotationFraction() - bias);
        if(step == 1) {
            telemetry.addData("Entered Case One:", step);
            for (int i = 0; i <10; i++){
                sum += a.getRotationFraction();
                //telemetry.addData ("Next Sum:", sum);

            }
            bias = sum/10;
            //long deltaTime = time2-time1;
            //time1.setNanos();
            step++;
        }
        //else if(step == 2) {
           // telemetry.addData("Entered Case Two:", step);
            //time2 = new Timestamp ((long) time);
        //}
            //telemetry.addData("fml", step);
        telemetry.addData ("Light:", light.getLightDetected());
        telemetry.addData ("Bias:", bias);
        telemetry.addData("time1: ", time1.getNanos());
        telemetry.addData("time2: ", time2.getNanos());
        telemetry.addData("Difference: ", (deltaTime/conversion));
        telemetry.addData("Theta: ", theta);
            //telemetry.addData("Time difference: ", (long)(time2.compareTo(time1)));
            //telemetry.addData("Time get: ", thingToGetTime.getTime());


            // telemetry.addData("time2-time1 =", time2.compareTo(time1));

    }

}
