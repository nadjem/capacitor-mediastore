export interface MediaStorePlugin {
  saveImage(options: SaveImageOptions): Promise<void>;
  saveDocument(options: SaveDocumentOptions): Promise<void>;
}

export interface SaveImageOptions {
  filename: string;
  content: Blob;
}

export interface SaveDocumentOptions {
  filename: string;
  content: Blob;
  mimeType: string;
}
