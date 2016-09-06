DenserOres
=========

<a rel="license" href="http://creativecommons.org/licenses/by/4.0/deed.en_GB"><img alt="Creative Commons Licence" style="border-width:0" src="http://i.creativecommons.org/l/by/4.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/4.0/deed.en_GB">Creative Commons Attribution 4.0 International License</a>.

Code is provided without guarantee of being error-free or optimal.


<br><b>Download of the latest release:</b> In the releases tab<br><br>


If you wish to add another mods ores to the game, you will need to alter the config file. I generally wouldn't recommend doing this if you are a casual player since this can cause issues. It's best to see if there is a modpack that does it properly for you. There is a simple denseores.cfg that includes a number of ores from some common mods here <a href="https://github.com/rwtema/DenseOres/blob/1.7/example_configs/denseores.cfg">https://github.com/rwtema/DenseOres/blob/1.7/example_configs/denseores.cfg</a><br>

You can also find individual example configs for common mods at <a href="https://github.com/rwtema/DenseOres/tree/1.7/example_configs/mods">https://github.com/rwtema/DenseOres/tree/1.7/example_configs/mods</a>. This will require you to change the ore ids when you add them to your config file. If anyone wishes to add more example configs for common mods, then please feel free to submit a pull request for it.<br>


<b>Older Versions and other important things:</b><br>
<a href="https://github.com/rwtema/DenseOres/">https://github.com/rwtema/DenseOres/</a>

<b>Config Info</b><br>
<i>S:baseBlock</i> - The ore block that you wish to replace. This is in the form modid:blockname<br>
<i>I:baseBlockMeta</i> - The metadata value for the block (0-15)<br>
<i>S:baseBlockTexture</i> - The ores texture name (as found in assets/modid/textures/blocks)<br>
<i>D:denseOreProbability</i> - Currently unused.<br>
<i>I:renderType</i> - This changes the way the texture generation works (see <a href="https://i.imgur.com/CGfhSss.png">here</a> for details).<br>
<i>I:retroGenId</i> - Retrogen number. Set it to non-zero to enable retrogen. You can change it to a diffent number to run retrogen again.<br>
<i>S:underlyingBlock</i> - The texture of the base block (usually stone or netherrack), see baseBlockTexture.<br>

