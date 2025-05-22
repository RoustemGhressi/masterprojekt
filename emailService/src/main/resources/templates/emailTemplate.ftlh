<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Ticket Details</title>
</head>
<body style="margin: 0; padding: 0; background-color: #f4f4f4; font-family: Arial, sans-serif;">

    <table width="100%" cellpadding="0" cellspacing="0" style="background-color: #f4f4f4; padding: 40px 0;">
        <tr>
            <td align="center">
                <table width="600" cellpadding="0" cellspacing="0" style="background-color: #ffffff; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); padding: 30px;">
                    <tr>
                        <td align="center" style="padding-bottom: 20px;">
                            <h1 style="font-size: 36px; margin: 0; color: #222;">🎟️ Ticket Details</h1>
                            <p style="font-size: 18px; color: #444;">Your payment has been successfully completed</p>
                        </td>
                    </tr>

                    <tr>
                        <td style="font-size: 16px; color: #333; line-height: 1.6;">
                            <p>Dear <strong>${fullName}</strong>,</p>
                            <p>Thank you for choosing <strong>CineVision</strong> to purchase your ticket.</p>

                            <h3 style="color: #222; margin-top: 30px;">🎬 Ticket Information</h3>
                            <p><strong>Movie:</strong> ${movieName}</p>
                            <p><strong>Date:</strong> ${movieDay}</p>
                            <p><strong>Cinema:</strong> ${saloonName}</p>
                            <p><strong>Showtime:</strong> ${movieStartTime}</p>
                            <p><strong>Seat(s):</strong> ${chairNumbers}</p>

                            <p style="margin-top: 30px;">As the CineVision family, we wish you a pleasant viewing experience!</p>
                        </td>
                    </tr>

                    <tr>
                        <td align="center" style="padding-top: 30px; font-size: 14px; color: #999;">
                            &copy; 2025 CineVision. All rights reserved.
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>

</body>
</html>

