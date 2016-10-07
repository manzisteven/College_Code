package mobilestressmeter.edu.cmu.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import java.util.Calendar;

/**
 * This BroadcastReceiver automatically (re)starts the alarm when the device is
 * rebooted. This receiver is set to be disabled (android:enabled="false") in the
 * application's manifest file. When the user sets the alarm, the receiver is enabled.
 * When the user cancels the alarm, the receiver is disabled, so that rebooting the
 * device will not trigger this receiver.
 */
// BEGIN_INCLUDE(autostart)
public class SampleBootReceiver extends BroadcastReceiver {

    SampleAlarmReceiver alarm = new SampleAlarmReceiver();
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    @Override

        public void onReceive(Context context, Intent intent) {
            alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
            {
                alarm.setAlarm(context);
                alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        AlarmManager.INTERVAL_HALF_HOUR,
                        AlarmManager.INTERVAL_HALF_HOUR, alarmIntent);
            }
        }
}
//END_INCLUDE(autostart)
