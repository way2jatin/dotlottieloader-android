package io.dotlottie.loader.models

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import java.io.Serializable


internal val moshi by lazy {
    Moshi.Builder()
        .build()
}

internal val manifestAdapter by lazy {
    moshi.adapter(Manifest::class.java)
}

/**
 * The manifest for a dotLottie
 * provides information about the animation, and
 * describes the contents of the bundle
 */
@JsonClass(generateAdapter = true)
data class Manifest(
    val generator: String,
    val version: Float,
    val revision: Int?,
    val author: String,
    val animations: List<ManifestAnimation>,
    val custom: Map<String, Any>?
): Serializable

/**
 * Animation spec as declared in the [Manifest].
 * All dotLotties MUST contain at least one
 */
@JsonClass(generateAdapter = true)
data class ManifestAnimation(
    val id: String,
    val speed: Float = 1.0f,
    val themeColor: String?,
    val loop: Boolean = false
): Serializable

/**
 * A DotLottie file
 */
@JsonClass(generateAdapter = true)
data class DotLottie(
    val manifest: Manifest?,
    val animations: Map<String, ByteArray>,
    val images: Map<String, ByteArray>
    //fonts
    //js
    //resources
    //previews
): Serializable