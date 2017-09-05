//idk what i'm doing
package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="Teleopmecanum", group="Pushbot")
//@Disabled
public class boat extends OpMode{

    NathanPushboat boat = new NathanPushboat();
    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        boat.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Boat is ready to be sailed!");
        telemetry.update();
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {

    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        telemetry.addData("Say", "Starting to receive information from your controller!");
        telemetry.update();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        double threshold = 0.2;
        double frontPower = - gamepad1.left_stick_y;
        double rightPower = gamepad1.left_stick_x;

        telemetry.addData("Say", "Doopaddo: " + gamepad1.left_stick_y);
        telemetry.update();
        if(java.lang.Math.abs(gamepad1.left_stick_y) > threshold || java.lang.Math.abs(gamepad1.left_stick_x) > threshold)
        {
            boat.front_left_motor.setPower((frontPower - .5*rightPower)*.65);
            boat.front_right_motor.setPower((frontPower + .5*rightPower)*.65);
            boat.back_left_motor.setPower((frontPower + .8*rightPower)*.65);
            boat.back_right_motor.setPower((frontPower - .8*rightPower)*.65);
        }
        else if (java.lang.Math.abs(gamepad1.right_stick_x) < threshold)
        {
            boat.front_right_motor.setPower(0);
            boat.front_left_motor.setPower(0);
            boat.back_left_motor.setPower(0);
            boat.back_right_motor.setPower(0);
        }


        if (java.lang.Math.abs(gamepad1.right_stick_x) > threshold)
        {
            boat.front_right_motor.setPower((boat.front_right_motor.getPower() + .7*gamepad1.right_stick_x)*1.3);
            boat.front_left_motor.setPower((boat.front_left_motor.getPower() - .7*gamepad1.right_stick_x)*1.3);
            boat.back_right_motor.setPower((boat.back_right_motor.getPower() + .7*gamepad1.right_stick_x)*1.3);
            boat.back_left_motor.setPower((boat.back_left_motor.getPower() - .7*gamepad1.right_stick_x)*1.3);
        }
    }

//happens when you press stop
    @Override
    public void stop() {
        telemetry.addData("Say", "Boat docked.");
        telemetry.update();
    }

}