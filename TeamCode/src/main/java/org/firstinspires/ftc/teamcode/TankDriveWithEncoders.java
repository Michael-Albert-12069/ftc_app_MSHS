package org.firstinspires.ftc.teamcode;

/**
 * Created by michaelalbert on 10/15/17.
 */
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by michaelalbert on 10/14/17.
 */
@TeleOp(name = "Michael - USE THIS GUYS ", group = "TeleOp")
//@Disabled
public class TankDriveWithEncoders extends LinearOpMode {
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private DcMotor armmotor;
    private Servo armclaw;

    @Override
    public void runOpMode() throws InterruptedException {
        double armpowerdown;
        double armpowerup;
        leftmotor = hardwareMap.dcMotor.get("leftmotor");
        rightmotor = hardwareMap.dcMotor.get("rightmotor");

        armmotor = hardwareMap.dcMotor.get("arm");

        armclaw = hardwareMap.servo.get("armclaw");
        leftmotor.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();

        armclaw.setPosition(0.00);

        while ((opModeIsActive())) {


            //servo left max= 0; close = 140
            //servo right max= 145; close = 0

            armpowerup= gamepad1.right_trigger ;
            armmotor.setPower(armpowerup);
            armpowerdown= -gamepad1.left_trigger/2;
            armmotor.setPower(armpowerdown);


            if(gamepad1.a){
//            open
                    armclaw.setPosition(0.05);
            }else {
//            close
                if (gamepad1.b) {
                    armclaw.setPosition(0.33);
                }
            }




            rightmotor.setPower(gamepad1.right_stick_y/1.5);
            leftmotor.setPower(gamepad1.left_stick_y/1.5);
            telemetry.update();
            idle();
        }
    }
}