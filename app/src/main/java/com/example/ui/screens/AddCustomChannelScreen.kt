package com.example.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLink
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.data.model.Channel
import com.example.data.model.ChannelCategory
import com.example.ui.theme.CyanPrimary
import com.example.ui.theme.RedLive
import com.example.ui.theme.SurfaceVariantDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCustomChannelScreen(
    customChannels: List<Channel>,
    onAddChannel: (nameArabic: String, nameEnglish: String, streamUrl: String, category: ChannelCategory, country: String, logoUrl: String) -> Unit,
    onDeleteChannel: (String) -> Unit,
    onPlayChannel: (Channel) -> Unit,
    modifier: Modifier = Modifier
) {
    var channelNameArabic by remember { mutableStateOf("") }
    var channelNameEnglish by remember { mutableStateOf("") }
    var streamUrl by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var logoUrl by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(ChannelCategory.ENTERTAINMENT) }
    var isCategoryDropdownExpanded by remember { mutableStateOf(false) }
    var validationError by remember { mutableStateOf<String?>(null) }
    var successMessage by remember { mutableStateOf<String?>(null) }

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxSize()
            .testTag("add_custom_channel_screen")
    ) {
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.AddLink,
                    contentDescription = "Add Link",
                    tint = CyanPrimary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = "إضافة قناة أو رابط بث خاص (IPTV / M3U8)",
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "أضف أي رابط بث مباشر ترغب بمتابعته داخل التطبيق",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 12.sp
                    )
                }
            }
        }

        // Form Card
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = SurfaceVariantDark),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Channel Name (Arabic)
                    OutlinedTextField(
                        value = channelNameArabic,
                        onValueChange = {
                            channelNameArabic = it
                            validationError = null
                        },
                        label = { Text("اسم القناة بالعربية *") },
                        placeholder = { Text("مثال: قناة الأخبار المستقلة") },
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = CyanPrimary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.outline
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("custom_channel_name_arabic")
                    )

                    // Stream URL
                    OutlinedTextField(
                        value = streamUrl,
                        onValueChange = {
                            streamUrl = it
                            validationError = null
                        },
                        label = { Text("رابط البث المباشر (HLS .m3u8 / MP4) *") },
                        placeholder = { Text("https://example.com/live/stream.m3u8") },
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = CyanPrimary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.outline
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("custom_channel_stream_url")
                    )

                    // Category Dropdown
                    ExposedDropdownMenuBox(
                        expanded = isCategoryDropdownExpanded,
                        onExpandedChange = { isCategoryDropdownExpanded = !isCategoryDropdownExpanded },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = selectedCategory.titleArabic,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("التصنيف") },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isCategoryDropdownExpanded) },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = CyanPrimary,
                                unfocusedBorderColor = MaterialTheme.colorScheme.outline
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor()
                        )
                        ExposedDropdownMenu(
                            expanded = isCategoryDropdownExpanded,
                            onDismissRequest = { isCategoryDropdownExpanded = false }
                        ) {
                            ChannelCategory.values().filter { it != ChannelCategory.ALL }.forEach { category ->
                                DropdownMenuItem(
                                    text = { Text(category.titleArabic) },
                                    onClick = {
                                        selectedCategory = category
                                        isCategoryDropdownExpanded = false
                                    }
                                )
                            }
                        }
                    }

                    // Country
                    OutlinedTextField(
                        value = country,
                        onValueChange = { country = it },
                        label = { Text("البلد أو المصدر (اختياري)") },
                        placeholder = { Text("مثال: العراق، مصر، أو خاص") },
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = CyanPrimary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.outline
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("custom_channel_country")
                    )

                    // Logo URL
                    OutlinedTextField(
                        value = logoUrl,
                        onValueChange = { logoUrl = it },
                        label = { Text("رابط الشعار أو الصورة (اختياري)") },
                        placeholder = { Text("https://example.com/logo.png") },
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = CyanPrimary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.outline
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("custom_channel_logo_url")
                    )

                    // Error or Success Feedback
                    if (validationError != null) {
                        Text(
                            text = validationError ?: "",
                            color = RedLive,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    if (successMessage != null) {
                        Text(
                            text = successMessage ?: "",
                            color = Color(0xFF34D399),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    // Save Button
                    Button(
                        onClick = {
                            if (channelNameArabic.isBlank()) {
                                validationError = "يرجى إدخال اسم القناة"
                                return@Button
                            }
                            if (streamUrl.isBlank() || (!streamUrl.startsWith("http://") && !streamUrl.startsWith("https://"))) {
                                validationError = "يرجى إدخال رابط بث صحيح يبدأ بـ http أو https"
                                return@Button
                            }

                            onAddChannel(
                                channelNameArabic.trim(),
                                channelNameEnglish.trim().ifBlank { channelNameArabic.trim() },
                                streamUrl.trim(),
                                selectedCategory,
                                country.trim().ifBlank { "مخصص" },
                                logoUrl.trim()
                            )

                            // Reset form
                            channelNameArabic = ""
                            channelNameEnglish = ""
                            streamUrl = ""
                            country = ""
                            logoUrl = ""
                            validationError = null
                            successMessage = "تمت إضافة القناة بنجاح إلى قائمتك!"
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = CyanPrimary,
                            contentColor = Color.Black
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .testTag("submit_custom_channel_button")
                    ) {
                        Text(
                            text = "حفظ القناة في التطبيق",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        // Custom Channels List Section
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "قنواتك المضافة (${customChannels.size})",
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        if (customChannels.isEmpty()) {
            item {
                Surface(
                    color = SurfaceVariantDark.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier.padding(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "لم تقم بإضافة أي قنوات خاصة بعد",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 13.sp
                        )
                    }
                }
            }
        } else {
            items(customChannels, key = { it.id }) { channel ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = SurfaceVariantDark),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            AsyncImage(
                                model = channel.logoUrl,
                                contentDescription = channel.nameArabic,
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = channel.nameArabic,
                                    color = Color.White,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "${channel.category.titleArabic} • ${channel.country}",
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    fontSize = 11.sp
                                )
                            }
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(
                                onClick = { onPlayChannel(channel) },
                                modifier = Modifier.testTag("play_custom_${channel.id}")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.PlayArrow,
                                    contentDescription = "Play",
                                    tint = CyanPrimary
                                )
                            }

                            IconButton(
                                onClick = { onDeleteChannel(channel.id) },
                                modifier = Modifier.testTag("delete_custom_${channel.id}")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete",
                                    tint = RedLive
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
