package com.example.android_itis_2022

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.core.content.getSystemService
import com.example.android_itis_2022.databinding.ActivityMainBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var picker: MaterialTimePicker
    private lateinit var calendar: Calendar
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createNotificationChannel()

        binding.tvTime.setOnClickListener {
            showTimePicker()
        }

        binding.btnStart.setOnClickListener {
            setAlarm()
        }

        binding.btnStop.setOnClickListener {
            cancelAlarm()
        }
    }

    private fun cancelAlarm() {

        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)

        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)

        alarmManager.cancel(pendingIntent)
        Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_LONG).show()
    }

    private fun setAlarm() {

        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)

        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)

        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,pendingIntent
        )
        Toast.makeText(this, "Alarm set Successfuly", Toast.LENGTH_SHORT).show()
    }

    private fun showTimePicker() {

        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Alarm Time")
            .build()

        picker.show(supportFragmentManager, "picker")

        picker.addOnPositiveButtonClickListener {

            if (picker.hour > 12) {
                binding.tvTime.text =
                    String.format("%02d", picker.hour - 12) + " : " + String.format(
                        "%02d",
                        picker.minute
                    ) + "PM"
            } else {
                String.format("%02d", picker.hour) + " : " + String.format(
                    "%02d",
                    picker.minute
                ) + "AM"
            }
            calendar = Calendar.getInstance()
            calendar[Calendar.HOUR_OF_DAY] = picker.hour
            calendar[Calendar.MINUTE] = picker.minute
            calendar[Calendar.SECOND] = 0
            calendar[Calendar.MILLISECOND] = 0
        }
    }

    private fun createNotificationChannel() {

        val music: Uri = Uri.parse(
            "android.resource://" + this.packageName + "/" + R.raw.winda
        )
        val vibration = arrayOf(300L, 100L).toLongArray()
        val audioAttributes: AudioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
            .build()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "NameAlarmManager"
            val description = "DescriptionAlarmManager"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("channel", name, importance)
            channel.description = description
            channel.setSound(music,audioAttributes)
            channel.vibrationPattern=vibration
            channel.lightColor = Color.GREEN

            val notificationManager = getSystemService(
                NotificationManager::class.java
            )

            notificationManager.createNotificationChannel(channel)
        }
    }
}