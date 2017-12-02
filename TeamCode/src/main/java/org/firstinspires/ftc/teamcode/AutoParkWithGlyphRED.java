package org.firstinspires.ftc.teamcode;

/**
 * Created by michaelalbert on 10/15/17.
 */
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by michaelalbert on 10/14/17.
 */
@Autonomous(name = "Michael - Auto. Park Glyph Blue between", group = "Autonomous")
public class AutoParkWithGlyphRED extends LinearOpMode {
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private Servo armclaw;
    private DcMotor armmotor;
    private int targetposition;

    @Override
    public void runOpMode() throws InterruptedException {

        leftmotor = hardwareMap.dcMotor.get("leftmotor");
        rightmotor = hardwareMap.dcMotor.get("rightmotor");
        leftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armclaw = hardwareMap.servo.get("armclaw");
        leftmotor.setDirection(DcMotor.Direction.REVERSE);
        armmotor = hardwareMap.dcMotor.get("arm");

        waitForStart();
        CloseServo();
        LiftSlide(2000);
        Drive4ward(DRIVE_POWER, 500);
        turnRight(DRIVE_POWER, 750);
        Drive4ward(DRIVE_POWER, 500);
        stopDrive(ZERO_SPEED, 300);
        OpenServo();
        Drive4ward(-DRIVE_POWER, 100);


    }
    double DRIVE_POWER = -.5;
    double ZERO_SPEED = 00.00;

    public void CloseServo(){
        armclaw.setPosition(0.28);
    }
    public void LiftSlide(long time) throws InterruptedException {
        armmotor.setPower(1);
        Thread.sleep(time);
    }
    public void OpenServo(){
        armclaw.setPosition(0.00);
    }
    public void Drive4ward(double power, long time) throws InterruptedException {
        leftmotor.setPower(power);
        rightmotor.setPower(power);
        Thread.sleep(time);

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