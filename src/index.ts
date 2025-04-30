import { registerPlugin } from '@capacitor/core';
import type { MediaStorePlugin } from './definitions';

const MediaStore = registerPlugin<MediaStorePlugin>('MediaStore', {
  web: () => import('./web').then(m => new m.MediaStoreWeb()),
});

export * from './definitions';
export { MediaStore };
