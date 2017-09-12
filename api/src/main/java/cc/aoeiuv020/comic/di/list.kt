package cc.aoeiuv020.comic.di

import cc.aoeiuv020.comic.api.ComicGenre
import cc.aoeiuv020.comic.api.ComicListItem
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import javax.inject.Singleton

/**
 * 提供漫画列表，
 * Created by AoEiuV020 on 2017.09.12-17:49:22.
 */
@Singleton
@Component(modules = arrayOf(ListModule::class))
interface ListComponent {
    fun getComicList(): Observable<ComicListItem>
}

@Module
class ListModule(val comicGenre: ComicGenre) {
    @Provides
    fun getComicList(): Observable<ComicListItem>
            = Observable.fromIterable(ctx(comicGenre.url).getComicList(comicGenre))
}