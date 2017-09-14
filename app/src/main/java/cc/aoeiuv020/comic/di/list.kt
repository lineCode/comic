package cc.aoeiuv020.comic.di

import android.content.Context
import cc.aoeiuv020.comic.api.ComicGenre
import cc.aoeiuv020.comic.api.ComicListItem
import cc.aoeiuv020.comic.ui.App
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import io.reactivex.Observable

/**
 * 提供漫画列表，
 * Created by AoEiuV020 on 2017.09.12-17:49:22.
 */
@Subcomponent(modules = arrayOf(ListModule::class))
interface ListComponent {
    fun getComicList(): Observable<ComicListItem>
}

@Module
class ListModule(val comicGenre: ComicGenre) {
    init {
        App.component.ctx.getSharedPreferences("genre", Context.MODE_PRIVATE)
                .edit()
                .putString("name", comicGenre.name)
                .putString("url", comicGenre.url)
                .apply()
    }

    @Provides
    fun getComicList(): Observable<ComicListItem> = Observable.create { em ->
        ctx(comicGenre.url).getComicList(comicGenre).forEach {
            em.onNext(it)
        }
        em.onComplete()
    }
}