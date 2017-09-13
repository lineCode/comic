package cc.aoeiuv020.comic.api

import org.junit.Before
import org.junit.Test

/**
 * 动漫屋的测试类，
 * Created by AoEiuV020 on 2017.09.13-16:29:56.
 */
class Dm5Text {
    init {
        System.setProperty("org.slf4j.simpleLogger.log.Dm5Context", "trace")
    }

    private lateinit var context: Dm5Context
    @Before
    fun setUp() {
        context = Dm5Context()
    }

    @Test
    fun getGenres() {
        context.getGenres().forEach {
            println("[${it.name}](${it.url})")
        }
    }

    @Test
    fun getNextPage() {
    }

    @Test
    fun getComicList() {
        context.getComicList(ComicGenre("", "http://www.dm5.com/manhua-shaonianrexue/")).forEach {
            println(it.name)
            println(it.url)
            println(it.img)
        }
    }

    @Test
    fun getComicDetail() {
        context.getComicDetail(ComicListItem("妖神记", "", "http://www.dm5.com/manhua-yaoshenji/")).let {
            println(it.name)
            println(it.bigImg)
            println(it.info)
            it.issues.forEach { issue ->
                println("[${issue.name}](${issue.url})")
            }
        }
    }

    @Test
    fun getComicPages() {
        context.getComicPages(Dm5Context.Dm5ComicIssue("", "http://www.dm5.com/m523824/", 8)).forEach {
            println(it.url)
        }
    }

    @Test
    fun getComicImage() {
        context.getComicImage(Dm5Context.Dm5ComicPage("http://www.dm5.com/m523824/", "523824", 4)).let {
            println(it.img)
        }
    }
}