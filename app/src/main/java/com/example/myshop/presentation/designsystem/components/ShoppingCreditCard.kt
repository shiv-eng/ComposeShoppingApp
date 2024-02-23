package com.example.myshop.presentation.designsystem.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myshop.R
import com.example.myshop.presentation.designsystem.theme.ShoppingAppTheme

@Composable
fun ShoppingCreditCard(
    cardHolderName: String,
    cardNumber: String,
    cardExpiryDate: String,
    cvc: String,
    rotated: Boolean,
    onCardClick: () -> Unit
) {
    val density = LocalDensity.current.density
    val rotation by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(500),
        label = "rotation"
    )

    val animateFront by animateFloatAsState(
        targetValue = if (!rotated) 1f else 0f,
        animationSpec = tween(500),
        label = "animateFront"
    )

    val animateBack by animateFloatAsState(
        targetValue = if (rotated) 1f else 0f,
        animationSpec = tween(500),
        label = "animateBack"
    )

    Card(
        modifier = Modifier
            .height(220.dp)
            .fillMaxWidth()
            .clickable { onCardClick() }
            .padding(16.dp),
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(contentColor = Color.White),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(14.dp))
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF64B5F6),
                            Color(0xFF42A5F5),
                            Color(0xFF2196F3),
                            Color(0xFF1E88E5)
                        )
                    )
                )
                .padding(16.dp)
        ) {
            if (!rotated) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Contactless",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .graphicsLayer(alpha = animateFront)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "Card",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .graphicsLayer(alpha = animateFront)
                        )
                    }

                    Text(
                        text = "**** **** **** ${cardNumber.takeLast(4)}",
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .graphicsLayer(alpha = animateFront),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineMedium,
                    )

                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(horizontalAlignment = Alignment.Start) {
                            Text(
                                text = "Card Holder",
                                color = Color.Gray,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .graphicsLayer(alpha = animateFront)
                            )
                            Text(
                                text = cardHolderName,
                                color = Color.White,
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier
                                    .graphicsLayer(alpha = animateFront)
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Column(horizontalAlignment = Alignment.Start) {
                            Text(
                                text = "Expiry",
                                color = Color.Gray,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .graphicsLayer(alpha = animateFront)
                            )
                            Text(
                                text = cardExpiryDate.chunked(2).joinToString(separator = "/"),
                                color = Color.White,
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier
                                    .graphicsLayer(alpha = animateFront)
                            )
                        }
                    }
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .graphicsLayer(alpha = animateBack),
                        color = Color.Black
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Security",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.graphicsLayer(alpha = animateBack)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = cvc,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier
                                .graphicsLayer(alpha = animateBack)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ShoppingCreditCardPreview() {
    ShoppingAppTheme {
        Surface {
            ShoppingCreditCard(
                cardHolderName = "Shivangi",
                cardNumber = "5425 2334 3010 9903",
                cardExpiryDate = "08/27",
                cvc = "111",
                rotated = false,
                onCardClick = {}
            )
        }
    }
}

@Preview(name = "rotated")
@Composable
private fun ShoppingRotatedCreditCardPreview() {
    ShoppingAppTheme {
        Surface {
            ShoppingCreditCard(
                cardHolderName = "Shivangi",
                cardNumber = "5425 2334 3010 9903",
                cardExpiryDate = "08/27",
                cvc = "111",
                rotated = true,
                onCardClick = {}
            )
        }
    }
}
