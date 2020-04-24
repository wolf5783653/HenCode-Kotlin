package com.example.app

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.app.entity.User
import com.example.app.widget.CodeView
import com.example.core.utils.CacheUtils
import com.example.core.utils.Utils
import com.example.lesson.LessonActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // lateinit延迟初始化
    //1.声明类型不能是空类型
    //2.不能有初始值
    //3.不能初始化基本类型
    private  lateinit var et_username: EditText
    private  lateinit var et_password: EditText
    private  lateinit var et_code: EditText

    private var usernameKey: String = "6666"
    private var passwordKey: String = "6666222"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        et_code = findViewById(R.id.et_code)
        et_username?.setText(CacheUtils.get(usernameKey))
        et_password?.setText(CacheUtils.get(passwordKey))
        findViewById<Button>(R.id.btn_login).setOnClickListener(this)
        findViewById<CodeView>(R.id.code_view).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_login -> login()
            R.id.code_view -> CodeView(this).updateCode()
        }
    }

    fun login() {
        var username: String = et_username?.text.toString()
        var password: String = et_password?.text.toString()
        var code: String = et_code?.text.toString()
        var user = User(username, password, code)
        if (verify(user)) {
            CacheUtils.save(usernameKey, username)
            CacheUtils.save(passwordKey, password)
            startActivity(Intent(this, LessonActivity::class.java))
        }
    }

    fun verify(user: User): Boolean {
        if (user.username?.length ?: 0 < 4) {
            Utils.toast("用户名不合法",1)
            return false
        }
        if (user.password?.length ?: 0 < 4) {
            Utils.toast("密码不合法")
            return false
        }
        return true
    }
}