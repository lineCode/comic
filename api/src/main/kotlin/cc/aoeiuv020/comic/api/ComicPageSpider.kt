package cc.aoeiuv020.comic.api

/**
 * Created by AoEiuV020 on 17-5-31.
 */
abstract class ComicPageSpider : Spider() {
    abstract val pageCount: Int
    abstract fun imgUrl(i: Int): String
}