package org.firstinspires.ftc.teamcode;

/**
 * Created by michaelalbert on 10/15/17.
 */
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by michaelalbert on 10/14/17.
 */
@Autonomous(name = "Auto. Jewels Blue", group = "Autonomous")
public class AutonomousJewelsBlue extends LinearOpMode {
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private int targetposition;
    private ColorSensor sensorColor;
    private Servo colorServo;

    @Override
    public void runOpMode() throws InterruptedException {

        leftmotor = hardwareMap.dcMotor.get("leftmotor");
        rightmotor = hardwareMap.dcMotor.get("rightmotor");
        leftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sensorColor = hardwareMap.colorSensor.get("color");
        colorServo = hardwareMap.servo.get("colorservo");


        leftmotor.setDirection(DcMotor.Direction.REVERSE);
        double sensorBlue = sensorColor.blue();
        double sensorRed = sensorColor.red();

        waitForStart();
        OpenServo(servoOpen);

        if(sensorBlue<maxBlue & sensorBlue>minBlue){

            Drive4ward(DRIVE_POWER, 1000);
            CloseServo(servoClose);
            turnRight(DRIVE_POWER, 500);
            Drive4ward(DRIVE_POWER, 500);
        }
        else{

            turnRight(DRIVE_POWER, 500);
            CloseServo(servoClose);
            Drive4ward(DRIVE_POWER, 1000);

        }



    }
    double servoOpen = 50;
    double servoClose = 180;

    double DRIVE_POWER = -.75;
    double ZERO_SPEED = 00.00;

    double minBlue = 70;
    double maxBlue = 200;

    double minRed = 0;
    double maxRed = 0;

    public void Drive4ward(double power, long time) throws InterruptedException {
        leftmotor.setPower(power);
        rightmotor.setPower(power);
        Thread.sleep(time);

    }
    public void  OpenServo(double variableservo){
        colorServo.setPosition(variableservo);
    }

    public void  CloseServo(double servoVariable){
        colorServo.setPosition(servoVariable);
    }

    public void turnLeft(double power, long time) throws InterruptedException {
        leftmotor.setPower(-power);
        rightmotor.setPower(power);
        Thread.sleep(time);
    }
    public void turnRight(double power, long time) throws InterruptedException {
        leftmotor.setPower(power);
        rightmotor.setPower(-power);
        Thread.sleep(time);
    }
    public void stopDrive(double power, long time) throws InterruptedException {
        leftmotor.setPower(power);
        rightmotor.setPower(power);
        Thread.sleep(time);
    }
}