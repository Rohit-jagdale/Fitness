package com.example.fitness

import android.os.Build
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.FitnessTheme
import com.example.fitness.data.DataSource
import com.example.fitness.data.DataSource.fitnessData
import com.example.fitness.model.Fitness


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FitnessApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessApp(){
    Scaffold(
        topBar = {
            FittnessTopAppBar()
        }
    ) {it ->
        LazyColumn(contentPadding = it){
            items(fitnessData){
                FitnessCard(title = it, heading = it, image = it, detail = it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FittnessTopAppBar(modifier: Modifier= Modifier){
    CenterAlignedTopAppBar(
        title = {
        Column (verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,){
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayMedium
                    )
        }
        },
        modifier= modifier
    )
}

@Composable
fun FitnessCard(
    title: Fitness,
    heading: Fitness,
    image: Fitness,
    detail: Fitness, modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if(expanded) MaterialTheme.colorScheme.primaryContainer
        else MaterialTheme.colorScheme.tertiaryContainer
    )

    Card(modifier = modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color = color)
        ) {


            Text(
                text = LocalContext.current.getString(title.titleId),
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = LocalContext.current.getString(heading.headingId),
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(8.dp)
            )
            ClickableImageButton(
                expanded = expanded,
                image = image,
                heading = heading,
                onClick = { expanded = !expanded }
            )
            if (expanded) {
                Text(
                    text = LocalContext.current.getString(detail.detailId),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}
@Composable
fun ClickableImageButton(expanded: Boolean, image: Fitness, heading: Fitness, onClick: () -> Unit, modifier: Modifier = Modifier){
    Button(onClick = onClick,
        shape = RoundedCornerShape(8.dp),
            modifier = modifier) {
        Image(
            painter = painterResource(image.imageId),
            contentDescription = stringResource(heading.headingId),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .wrapContentSize()
        )
    }
}

@Preview
@Composable
private  fun CardPreview(){

}