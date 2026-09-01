const glob = require('glob');
const fs = require('fs');
const path = require('path');
const { promisify } = require('util');
const findFiles = promisify(glob);
const { md5FileSync } = require('./md5');

const versionHash = Math.random().toString(36).substring(7);
const distributionGeneratePath = './build/distribution.json';

const dirCache = './../../distributions/cache';
const dirCacheSnow = './../../distributions/cache_snow';
const dirLauncher = './../../distributions/launcher';

const projectName = 'NAVARA ROLEPLAY';
const packageName = 'com.touch.mobile.dark';

const cdnCache = 'https://game.navara-rp.com/mobile/cache';
const cdnLauncher = 'https://game.navara-rp.com/mobile/launcher';


const appVersion = '1.0.0';
const rss = '';

const filesContinue = ['settings.ini', 'gta_sa.set', 'svconfig.ini'];
const filesIgnore = ['samp_log.txt', 'crash_log.log', 'gtasatelem.set'];

//----------------

return new Promise(async () => {
	const cache = [];
	let cacheId = 1;
	const cacheSnow = [];
	let cacheSnowId = 1;
	const cacheMerge = [];
	let cacheMergeId = 1;

	// Launcher
	const clientPaths = await findFiles(
		`${path.resolve(dirLauncher)}/app-release.apk`
	);

	const clientCache = {
		appVersion,
		name: `app-release.apk`,
		hash: await md5FileSync(clientPaths[0]),
		mtime: unixTimeStamp(fs.statSync(clientPaths[0]).mtime),
		bytes: fs.statSync(clientPaths[0]).size,
	};

	// Cache основной
	const filePaths = await findFiles(`${path.resolve(dirCache)}/**/*`);
	for (const filePath of filePaths) {
		if (!fs.lstatSync(filePath).isDirectory()) {
			let nameFile = filePath.split('/').pop();

			if (filesIgnore.indexOf(nameFile) === -1) {
				const pathFile = filePath
					.replace(path.resolve(dirCache) + '/', '')
					.split('/');
				pathFile.pop();

				cache.push({
					id: cacheId,
					name: nameFile,
					path: pathFile.join('/'),
					bytes: [fs.statSync(filePath).size],
					gpu: getGpu(nameFile),
				});

				cacheId++;
			}
		}
	}

	// Кеш зимний
	const fileSnowPaths = await findFiles(`${path.resolve(dirCacheSnow)}/**/*`);
	for (const filePath of fileSnowPaths) {
		if (!fs.lstatSync(filePath).isDirectory()) {
			let nameFile = filePath.split('/').pop();

			if (filesIgnore.indexOf(nameFile) === -1) {
				const pathFile = filePath
					.replace(path.resolve(dirCacheSnow) + '/', '')
					.split('/');
				pathFile.pop();

				cacheSnow.push({
					id: cacheSnowId,
					name: nameFile,
					path: pathFile.join('/'),
					bytes: fs.statSync(filePath).size,
					gpu: getGpu(nameFile),
				});

				cacheSnowId++;
			}
		}
	}

	// Cache меrge
	const fileMergePaths = await findFiles(`${path.resolve(dirCache)}/**/*`);
	for (const filePath of filePaths) {
		if (!fs.lstatSync(filePath).isDirectory()) {
			let nameFile = filePath.split('/').pop();

			if (filesIgnore.indexOf(nameFile) === -1) {
				const pathFile = filePath
					.replace(path.resolve(dirCache) + '/', '')
					.split('/');
				pathFile.pop();

				for (const snow of cacheSnow) {
					if (cache[cacheMergeId - 1].name === snow.name) {
						cache[cacheMergeId - 1].bytes = [
							...cache[cacheMergeId - 1].bytes,
							snow.bytes,
						];
					}
				}

				cacheMergeId++;
			}
		}
	}

	// Cache меrge
	const cacheMode = [];
	let cacheModeId = 1;
	const fileModePaths = await findFiles(`${path.resolve(dirCache)}/**/*`);
	for (const filePath of filePaths) {
		if (!fs.lstatSync(filePath).isDirectory()) {
			let nameFile = filePath.split('/').pop();

			if (filesIgnore.indexOf(nameFile) === -1) {
				const pathFile = filePath
					.replace(path.resolve(dirCache) + '/', '')
					.split('/');
				pathFile.pop();

				for (const snow of cacheSnow) {
					if (cache[cacheModeId - 1].name === snow.name) {
						cacheMode.push(cache[cacheModeId - 1]);
					}
				}

				cacheModeId++;
			}
		}
	}

	fs.writeFileSync(
		distributionGeneratePath,
		JSON.stringify(
			{
				cache,
				cacheMode,
				projectName,
				packageName,
				versionHash,
				rss,
				cdnCache,
				cdnLauncher,
				filesContinue,
				launcher: clientCache,
				
		servers: [
	{
		id: 1,
		show: true,
		version: '1.0',
		icon: '',
		events: [],
		slot: 1000,
		bonus: false,
		name: 'NAVARA ROLEPLAY',
		description: 'سيرفر رول بلاي عربي',
		address: '',
		sampVersion: '0.3.7',
	},
],			
