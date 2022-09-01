package kz.arctan.composestateflow

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun ItemListView(
    mainViewModel: MainViewModel = viewModel(),
    navController: NavController
) {

}

@Composable
fun ItemListScreen(
    items: List<Item>,
    onItemCheck: (Item) -> Unit,
    onAddNewItemClick: () -> Unit,
    onItemDeleteClick: (Item) -> Unit,
    onItemClick: (Item) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            IconButton(
                onClick = onAddNewItemClick,
                modifier = Modifier
                    .background(color = Color.Cyan, shape = CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.add)
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            items(items = items) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick(item) },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(2.6f)) {
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.h5,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = item.content,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Row(
                        modifier = Modifier.weight(1f)
                    ) {
                        IconButton(onClick = { onItemDeleteClick(item) }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = stringResource(id = R.string.delete),
                                tint = Color.Red
                            )
                        }
                        Checkbox(
                            checked = item.completed,
                            onCheckedChange = {
                                onItemCheck(item)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ItemListScreenPreview() {
    ItemListScreen(
        items = listOf(
            Item(
                title = "Hellohrewilfkrlkwklfewhifhwilfhwfewewhfewli",
                content = "Worldfwefewfefewfewfewfewfewfewfwefwwefewfewfewfewfewfew",
                id = 0,
                completed = false
            ),
            Item(
                title = "Hello",
                content = "World",
                id = 0,
                completed = false
            ),
            Item(
                title = "Hello",
                content = "World",
                id = 0,
                completed = false
            )
        ),
        onItemCheck = {},
        onAddNewItemClick = {},
        onItemDeleteClick = {},
        onItemClick = {}
    )
}