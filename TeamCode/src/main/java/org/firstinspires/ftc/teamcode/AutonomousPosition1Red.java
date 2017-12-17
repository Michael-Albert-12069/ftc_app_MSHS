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
@Autonomous(name = "Michael - Auto. 1 Red", group = "Autonomous")
public class AutonomousPosition1Red extends LinearOpMode {
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private Servo armclaw;
    private Servo colorServo;
    private DcMotor armmotor;
    private int targetposition;
    private ColorSensor sensorColor;

    @Override
    public void runOpMode() throws InterruptedException {

        leftmotor = hardwareMap.dcMotor.get("leftmotor");
        rightmotor = hardwareMap.dcMotor.get("rightmotor");
        leftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armclaw = hardwareMap.servo.get("armclaw");
        leftmotor.setDirection(DcMotor.Direction.REVERSE);
        armmotor = hardwareMap.dcMotor.get("arm");
        colorServo = hardwareMap.servo.get("colorservo");
        sensorColor = hardwareMap.colorSensor.get("color");

        waitForStart();
        CloseServo();
        LiftSlide(2, "sec");

        Extendsensor("open");
        if(sensorColor.red() > sensorColor.blue()){
            Turningeneral(0, 2);
            Turningeneral(0, -2);
            Extendsensor("close");
        }else{
            Turningeneral(0, -2);
            Turningeneral(0, 2);
            Extendsensor("close");
        }


        Turningeneral(1, 1);
        Turningeneral(1, 1);
        Turningeneral(2, -2);
        Turningeneral(1, 1);

        stopDrive(ZERO_SPEED, 300);
        OpenServo();
        Drive4ward(1);


    }
    double DRIVE_POWER = -.5;
    double ZERO_SPEED = 00.00;
    double ARMCLOSE= 0.28;
    double ARMOPEN= ARMCLOSE-0.23;
    //add value for this later
    double COLORCLOSE = 0;
    double COLOROPEN = 0;

    public void Extendsensor(String opnclose){
        if (opnclose.equals("open")){
            colorServo.setPosition(COLOROPEN);
        }
        if (opnclose.equals("close")){
            colorServo.setPosition(COLORCLOSE);
        }
    }

    public void CloseServo(){
        armclaw.setPosition(ARMCLOSE);
    }

    public void LiftSlide(int time, String fam) throws InterruptedException {
        armmotor.setPower(1);
        Thread.sleep(time * 1000);
    }
    public void OpenServo(){
        armclaw.setPosition(ARMOPEN);
    }

    public void Drive4ward(int rotations) throws InterruptedException {
        leftmotor.setTargetPosition(1440*rotations);
        rightmotor.setTargetPosition(1440 * rotations);
    }
    public void turnLeft(int rotations) throws InterruptedException {
        leftmotor.setTargetPosition(-1440 * rotations);
        rightmotor.setTargetPosition(1440 * rotations);
    }

    public void turnRight(int rotations) throws InterruptedException {
        leftmotor.setTargetPosition(1440 * rotations);
        rightmotor.setTargetPosition(-1440 * rotations);

    }
    public void Turningeneral(double right, double left){

        leftmotor.setTargetPosition((int) (1440 * left));
        rightmotor.setTargetPosition((int) (1440 * right));
    }
    public void stopDrive(double power, long time) throws InterruptedException {
        leftmotor.setPower(power);
        rightmotor.setPower(power);
        Thread.sleep(time);
    }
}