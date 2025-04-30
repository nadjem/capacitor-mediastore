# Capacitor MediaStore Plugin

A Capacitor plugin for managing media files on Android devices.

## Installation

```bash
npm install @agorapulse/capacitor-mediastore
npx cap sync
```

## Usage

```typescript
import { MediaStore } from '@agorapulse/capacitor-mediastore';

// Save an image
await MediaStore.saveImage({
  filename: 'my-image.jpg',
  content: blob // Blob containing the image data
});

// Save a document
await MediaStore.saveDocument({
  filename: 'my-document.pdf',
  content: blob, // Blob containing the document data
  mimeType: 'application/pdf'
});
```

## API

### saveImage(options: SaveImageOptions): Promise<void>

Save an image to the device's media store.

#### Options

| Name     | Type   | Description                |
|----------|--------|----------------------------|
| filename | string | Name of the file to save   |
| content  | Blob   | Blob containing image data |

### saveDocument(options: SaveDocumentOptions): Promise<void>

Save a document to the device's downloads folder.

#### Options

| Name     | Type   | Description                  |
|----------|--------|------------------------------|
| filename | string | Name of the file to save     |
| content  | Blob   | Blob containing file data    |
| mimeType | string | MIME type of the file (optional, defaults to 'application/octet-stream') |

## Capacitor 7 Support

This plugin is compatible with Capacitor 7 and follows its conventions:

- Uses ES Modules and `registerPlugin`
- Follows the new plugin structure
- Uses modern TypeScript features
- Implements proper error handling

## License

MIT
