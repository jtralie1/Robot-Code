/*package com.qualcomm.robotcore.eventloop.opmode;*/

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;

import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/*/*
 * WARNING: THIS CLASS IS SHARED BETWEEN THE classes AND pccomms PROJECTS.
 * DO NOT EDIT THE VERSION IN pccomms AS IT WILL BE OVERWRITTEN WHEN THE PROJECT IS BUILT.
 */
/*
@TeleOp(name = "gyroSensor", group = "Test")
 abstract public class gyroSensor extends OpMode implements GyroSensor {
    /**
     * The <code>ADSensorPort</code> passed in the constructor.
     */
/*
    protected GyroSensor port;
    private int offset = 0;
    private float gsRawTotal = 0f;
    private float gsvarianceTotal = 0f;
    private int samples = 1;
    private boolean calibrating = false;
    private long timestamp;
    private int consecutiveStdv = 0;
 GyroSensor a;

    public gyroSensor(GyroSensor port) {
        this.port = port;
        timestamp = System.currentTimeMillis();
    }

    public gyroSensor(GyroSensor port, int offset) {
        this(port);
        this.offset = offset;
    }

    /**
     * Read the gyro raw value and return with offset applied. Set offset to zero to return raw value.
     *
     * @return gyro value
     * @see #setOffset(int)
     * @see #getAngularVelocity
     */
/*
    public int readValue() {
        return (port.rawX() - offset /*+ rawY() + rawZ()*//* + port.rawY() - offset /*+ rawX() + rawZ() */ /*+ port.rawZ() - offset /* + rawY() + rawX()*//*);
    }

    /**
     * Set the offset used by <code>readValue()</code>. Default at instantiation is zero.
     *
     * @param offset The <code>int</code> offset value
     * @see #readValue
     *//*
    public void setOffset(int offset) {
        this.offset = offset;
    }
    public void init(){
        a = hardwareMap.gyroSensor.get("gyro1");


    }
    public void loop (){
        telemetry.addData("X is", a.rawX());
        telemetry.addData("Y is", a.rawY());
        telemetry.addData("Z is", a.rawZ());
    }
}

/** Calculate and return the current angular velocity. When integrating for a heading, values less than 1.0 can be ignored
 * to minimize perceived drift since the resolution of the Gyroscope sensor is 1 deg/sec.
 * <p>
**/