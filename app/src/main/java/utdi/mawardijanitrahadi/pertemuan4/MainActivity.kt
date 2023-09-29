package utdi.mawardijanitrahadi.pertemuan4

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import utdi.mawardijanitrahadi.pertemuan4.ui.theme.Pertemuan4Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.painter.Painter


@Composable
fun ContactCard() {
    // Data untuk kontak
    val contact = remember { Contact("Mawardi Janitra Hadi", "DevOps", "+6287728682255", "mawardi.janitra@students.utdi.ac.id") }

    // Bagian Logo, Nama, dan Jabatan
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Logo Aplikasi",
            modifier = Modifier
                .size(64.dp)
                .clip(shape = MaterialTheme.shapes.medium)
                .background(MaterialTheme.colorScheme.primary)
                .padding(8.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = contact.name, fontSize = 20.sp)
        Text(text = contact.position, fontSize = 16.sp)

        Spacer(modifier = Modifier.height(16.dp))
    }

    // Bagian Informasi Kontak
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            ContactInfoRow(
                icon = painterResource(id = R.drawable.phone_logo),
                text = contact.phoneNumber
            )
            ContactInfoRow(
                icon = painterResource(id = R.drawable.email_logo),
                text = contact.email
            )
        }
    }
}

@Composable
fun ContactInfoRow(icon: Painter, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .padding(end = 8.dp)
        )
        Text(text = text, fontSize = 16.sp)
    }
}

data class Contact(
    val name: String,
    val position: String,
    val phoneNumber: String,
    val email: String
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val contactList = (1..5).toList() // Ubah rentang IntRange menjadi List

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Kartu Nama") }
            )
        }
    ) {
        LazyColumn {
            items(contactList) { // daftar item sebagai parameter
                ContactCard()
            }
        }
    }
}