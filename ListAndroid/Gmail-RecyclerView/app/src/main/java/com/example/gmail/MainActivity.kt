package com.example.gmail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ItemSelect {
    lateinit var mails: MutableList<MailItemModel>
    lateinit var adapter: MailAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mails = mutableListOf(
            MailItemModel("Jane Austen", "16/12/2023"),
            MailItemModel("George Washington", "22/02/2023"),
            MailItemModel("Florence Nightingale", "12/05/2023"),
            MailItemModel("Alexander Hamilton", "11/01/2023"),
            MailItemModel("Emily Dickinson", "10/12/2023"),
            MailItemModel("Nikola Tesla", "10/07/2023"),
            MailItemModel("Charles Dickens", "07/02/2023"),
            MailItemModel("Ada Lovelace", "10/12/2023"),
            MailItemModel("Vincent van Gogh", "30/03/2023"),
            MailItemModel("Pablo Picasso", "25/10/2023"),
            MailItemModel("William Shakespeare", "26/04/2023"),
            MailItemModel("Julius Caesar", "12/07/2023"),
            MailItemModel("Homer", "10/08/2023"),
            MailItemModel("Socrates", "18/09/2023"),
            MailItemModel("Aristotle", "02/06/2023"),
            MailItemModel("Confucius", "28/09/2023"),
            MailItemModel("Queen Victoria", "24/05/2023")
        )

        adapter = MailAdapter(mails, this)

        val listMail = findViewById<RecyclerView>(R.id.list_mail)
        listMail.adapter = adapter
        listMail.layoutManager = LinearLayoutManager(this)
    }

    override fun CheckedMail(position: Int) {
        mails[position].isChecked = !mails[position].isChecked
        adapter.notifyItemChanged(position)
    }
}