package org.firstinspires.ftc.teamcode;

/**
 * Created by michaelalbert on 10/15/17.
 */
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by michaelalbert on 10/14/17.
 */
@TeleOp(name = "Michael - USE THIS GUYS SINGLE ZAIN", group = "TeleOp")
//@Disabled
public class CurrentDrive extends LinearOpMode {
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private DcMotor armmotor;
    private DcMotor armmotordupe;
    private Servo armclaw;
    public boolean speed;
    public double speedosped;

    @Override
    public void runOpMode() throws InterruptedException {
        double armpowerdown;
        double armpowerup;
        speed=true;

        leftmotor = hardwareMap.dcMotor.get("leftmotor");
        rightmotor = hardwareMap.dcMotor.get("rightmotor");
        armmotordupe = hardwareMap.dcMotor.get("armdupe");
        armmotor = hardwareMap.dcMotor.get("arm");

        armclaw = hardwareMap.servo.get("armclaw");
        leftmotor.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();

        armclaw.setPosition(0.00);

        while ((opModeIsActive())) {

            if(gamepad1.x) {
                speedosped = 1;
                speed=!speed;
                if (speed==false){
                    speedosped=0.5;
                }
            }
            //servo left max= 0; close = 140
            //servo right max= 145; close = 0
            armpowerdown= -gamepad1.left_trigger/2;
            armpowerup= gamepad1.right_trigger ;
            armmotor.setPower(armpowerup);

                armmotordupe.setPower(-armpowerup);


            armmotor.setPower(armpowerdown);

                 armmotordupe.setPower(-armpowerdown);


            if(gamepad1.a){
//            open
                armclaw.setPosition(0.00);
            }else {
//            close
                if (gamepad1.b) {
                    armclaw.setPosition(0.28);
                }
            }




            rightmotor.setPower(gamepad1.right_stick_y*speedosped);
            leftmotor.setPower(gamepad1.left_stick_y*speedosped);
            telemetry.update();
            idle();
        }
    }
}