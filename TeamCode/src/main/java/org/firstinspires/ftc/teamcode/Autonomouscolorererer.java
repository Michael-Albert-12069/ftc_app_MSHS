package org.firstinspires.ftc.teamcode;

/**
 * Created by michaelalbert on 10/15/17.
 */
import android.hardware.Sensor;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorAdafruitRGB;

/**
 * Created by michaelalbert on 10/14/17.
 */
@Autonomous(name = "colorererer", group = "Autonomous")
public class Autonomouscolorererer extends LinearOpMode {

    private ColorSensor sensorColor;


    @Override
    public void runOpMode() throws InterruptedException {


        sensorColor = hardwareMap.colorSensor.get("color");




        double sensorBlue = sensorColor.blue();
        double sensorRed = sensorColor.red();

        waitForStart();

while (opModeIsActive()){
    telemetry.addData("BLUE: ", sensorBlue);
    telemetry.addData("RED: ", sensorRed);
    telemetry.update();
}


    }

//    public void Drive4ward(double power, long time) throws InterruptedException {
//        leftmotor.setPower(power);
//        rightmotor.setPower(power);
//        Thread.sleep(time);
//
//    }
//    public void  OpenServo(double variableservo){
//        colorServo.setPosition(variableservo);
//    }
//
//    public void  CloseServo(double servoVariable){
//        colorServo.setPosition(servoVariable);
//    }
//
//    public void turnLeft(double power, long time) throws InterruptedException {
//        leftmotor.setPower(-power);
//        rightmotor.setPower(power);
//        Thread.sleep(time);
//    }
//    public void turnRight(double power, long time) throws InterruptedException {
//        leftmotor.setPower(power);
//        rightmotor.setPower(-power);
//        Thread.sleep(time);
//    }
//    public void stopDrive(double power, long time) throws InterruptedException {
//        leftmotor.setPower(power);
//        rightmotor.setPower(power);
//        Thread.sleep(time);
//    }
}