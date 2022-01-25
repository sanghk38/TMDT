-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 27, 2021 lúc 10:23 AM
-- Phiên bản máy phục vụ: 10.4.20-MariaDB
-- Phiên bản PHP: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `webbacken`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `level` int(11) NOT NULL,
  `created` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `admin`
--

INSERT INTO `admin` (`id`, `name`, `email`, `password`, `level`, `created`) VALUES
(1, 'Goo', 'admin@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 0, 2147483647),
(2, 'Mod đz', 'mod@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 1, 2147483647),
(3, 'Vippro', 'sanghk232@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 0, 33),
(4, 'Trương Công Tài', 'tai@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 0, 1634264095);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `catalog`
--

CREATE TABLE `catalog` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `parent_id` int(11) NOT NULL,
  `sort_order` tinyint(4) NOT NULL,
  `created` datetime NOT NULL,
  `hinhanh` varchar(1400) CHARACTER SET utf8 NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `catalog`
--

INSERT INTO `catalog` (`id`, `name`, `description`, `parent_id`, `sort_order`, `created`, `hinhanh`) VALUES
(6, 'Noel', '', 1, 6, '0000-00-00 00:00:00', ''),
(4, 'Phụ Kiện', 'abc', 1, 3, '0000-00-00 00:00:00', 'http://192.168.1.8/testadmin/upload/product/ao-so-mi-nu-vien-co-hoa-3dla1.jpg'),
(5, 'SALE', '', 1, 5, '0000-00-00 00:00:00', ''),
(3, 'Thời Trang Thương Hiệu', '', 1, 4, '0000-00-00 00:00:00', 'http://192.168.1.8/testadmin/upload/product/ao-so-mi-nu-vien-co-hoa-3dla1.jpg'),
(2, 'Thời trang nữ', '', 1, 2, '2017-04-22 05:37:36', 'http://192.168.1.8/testadmin/upload/product/ao-so-mi-nu-vien-co-hoa-3dla1.jpg'),
(1, 'Thời trang nam', '', 1, 1, '2017-04-22 05:37:23', 'http://192.168.1.8/testadmin/upload/product/94124bf8-81af-3600-1357-0018199fa3c42.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mytable`
--

CREATE TABLE `mytable` (
  `id` int(11) NOT NULL,
  `transaction_id` int(100) NOT NULL,
  `product_id` int(100) NOT NULL,
  `qty` int(100) NOT NULL DEFAULT 0,
  `amount` decimal(15,2) NOT NULL DEFAULT 0.00,
  `status` int(11) NOT NULL DEFAULT 0
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `oderr`
--

CREATE TABLE `oderr` (
  `id` int(11) NOT NULL,
  `transaction_id` int(100) NOT NULL,
  `product_id` int(100) NOT NULL,
  `qty` int(100) NOT NULL DEFAULT 0,
  `sizes` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `amount` decimal(15,2) NOT NULL DEFAULT 0.00,
  `status` int(11) NOT NULL DEFAULT 0
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `oderr`
--

INSERT INTO `oderr` (`id`, `transaction_id`, `product_id`, `qty`, `sizes`, `amount`, `status`) VALUES
(51, 77, 13, 1, 'S', '200000.00', 0),
(50, 77, 155, 1, 'S', '249000.00', 0),
(49, 76, 170, 1, 'S', '249000.00', 0),
(48, 75, 155, 2, 'S', '498000.00', 0),
(47, 74, 85, 1, 'S', '275000.00', 0),
(46, 73, 15, 1, 'S', '350000.00', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order`
--

CREATE TABLE `order` (
  `id` int(11) NOT NULL,
  `transaction_id` int(100) NOT NULL,
  `product_id` int(100) NOT NULL,
  `qty` int(100) NOT NULL DEFAULT 0,
  `amount` decimal(15,2) NOT NULL DEFAULT 0.00,
  `status` int(11) NOT NULL DEFAULT 0
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `order`
--

INSERT INTO `order` (`id`, `transaction_id`, `product_id`, `qty`, `amount`, `status`) VALUES
(1, 3, 12, 1, '360000.00', 0),
(3, 4, 7, 1, '350000.00', 0),
(12, 9, 4, 1, '200000.00', 0),
(13, 10, 17, 1, '450000.00', 0),
(6, 5, 23, 1, '370000.00', 0),
(7, 6, 28, 1, '169000.00', 0),
(8, 6, 25, 1, '300000.00', 0),
(11, 8, 10, 1, '69000.00', 0),
(10, 7, 11, 1, '70000.00', 0),
(14, 11, 25, 1, '300000.00', 0),
(15, 12, 28, 1, '169000.00', 0),
(16, 13, 29, 1, '180000.00', 0),
(17, 14, 26, 3, '345000.00', 0),
(36, 38, 21, 5, '900000.00', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` int(255) NOT NULL,
  `catalog_id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `content` text COLLATE utf8_unicode_ci NOT NULL,
  `price` decimal(15,2) NOT NULL DEFAULT 0.00,
  `price_new` decimal(15,3) NOT NULL,
  `discount` int(11) DEFAULT 0,
  `image_link` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `image_list` text COLLATE utf8_unicode_ci NOT NULL,
  `view` int(11) NOT NULL DEFAULT 0,
  `buyed` int(255) NOT NULL,
  `rate_total` int(255) NOT NULL DEFAULT 4,
  `rate_count` int(255) NOT NULL DEFAULT 1,
  `created` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `catalog_id`, `name`, `content`, `price`, `price_new`, `discount`, `image_link`, `image_list`, `view`, `buyed`, `rate_total`, `rate_count`, `created`) VALUES
(97, 4, 'KÍNH THỜI TRANG NAM ALDO', 'Thương hiệu thời trang ALDO là hãng thời trang Canada chuyên mang đến những thiết kế sang trọng và tinh tế về phụ kiện giầy dép và túi xách.', '315000.00', '0.000', 0, 'Kính_thời_trang_nam_ALDO1.jpg', '[]', 0, 0, 4, 1, 1638295584),
(155, 1, 'Áo Polo Nam Ngắn Tay Slimfit Coolmax', 'Chất liệu: Coolmax với thành phần: 71% Cotton, 24% Coolmax, 5% Spandex\r\nVải coolmax nhẹ, xốp, hút ẩm nhanh và khô nhanh tạo sự thoải mái cho cơ thể khi sử dụng\r\nBề mặt sợi có rãnh làm tăng khả năng truyền dẫn khí và ẩm   \r\nTính đàn hồi co giãn tốt, ít nhàu, tiện dụng khi vận động và sử dụng trong mọi hoàn cảnh\r\n', '249000.00', '0.000', 0, 'apm3757-tbd-71.jpg', '[]', 0, 2, 4, 1, 1640007539),
(156, 1, 'Áo Polo Nam Coolmax Ngắn Tay Phối Bo', 'Chất liệu: Coolmax với thành phần: 71% Cotton, 24% Coolmax, 5% Spandex\r\nVải coolmax nhẹ, xốp, hút ẩm nhanh và khô nhanh tạo sự thoải mái cho cơ thể khi sử dụng\r\nBề mặt sợi có rãnh làm tăng khả năng truyền dẫn khí và ẩm   \r\nTính đàn hồi co giãn tốt, ít nhàu, tiện dụng khi vận động và sử dụng trong mọi hoàn cảnh\r\n', '249000.00', '0.000', 0, 'apm3405-ddo-21.jpg', '[]', 0, 0, 4, 1, 1640007576),
(162, 1, 'Áo Sơ Mi Nam Tay Dài Kẻ Sọc Caro', 'Chất liệu vải Flannel 100% cotton\r\nThay thế những chiếc áp sơ mi mỏng mùa xuân hè của bạn\r\nThiết kế trẻ trung như cổ tay cài cúc, túi ngực có kích thước vừa phải\r\nChất liệu cotton mềm hoạc tiết kẻ caro giúp cho sản phẩm thêm khỏe khoắn, trẻ trung\r\nThay thế những chiếc áp sơ mi mỏng mùa xuân hè của bạn.\r\nChiếc sơ mi flannel vì sự bền bỉ thêm phần mềm mại, ấm áp, thoải mái\r\n', '273100.00', '0.000', 0, 'apm3791-xam-12.jpg', '[]', 0, 0, 4, 1, 1640007799),
(163, 1, 'Áo Sơ Mi Nam Caro Tay Dài Thời Trang', 'Chất liệu vải Flannel 100% cotton\r\nThay thế những chiếc áp sơ mi mỏng mùa xuân hè của bạn\r\nThiết kế trẻ trung như cổ tay cài cúc, túi ngực có kích thước vừa phải\r\nChất liệu cotton mềm hoạc tiết kẻ caro giúp cho sản phẩm thêm khỏe khoắn, trẻ trung\r\nThay thế những chiếc áp sơ mi mỏng mùa xuân hè của bạn.\r\nChiếc sơ mi flannel vì sự bền bỉ thêm phần mềm mại, ấm áp, thoải mái\r\n', '279000.00', '0.000', 0, 'apm4350-xng-71.jpg', '[]', 0, 0, 4, 1, 1640007838),
(86, 2, 'CHÂN VÁY JEAN PHỐI TÚI', 'Chân váy jean phối túi\r\n- Tên Sản Phẩm: Chân váy jean phối túi\r\n- Giá Bán: 495,000vnđ\r\n- Màu Sắc: XANH, ĐEN\r\n- Số Đo Eo: 66CM\r\n- Số Đo Mông: 94CM\r\n- Chiều Dài Chân Váy: 42CM\r\n- Thông Số Size S\r\n- Số Size S-M-L-XL\r\n- Chất Liệu Vải: JEANS\r\n- CÓ TÚI\r\n- CÓ QUẦN TRONG\r\n*CHÂN VÁY JEANS FORM A CƠ BẢN, BẢN LƯNG KHOẢNG 3.5CM, CHÂN VÁY CÓ PAGHET, DÂY KÉO Ở GIỮA, CÓ NÚT, SƯỜN BÊN TRÁI CÓ PHỐI TÚI HỘP TẠO KIỂU.', '495000.00', '346500.000', 148500, 'chanvay_jean_one_01.jpg', '[\"chanvay_jean_one_02.jpg\"]', 0, 0, 4, 1, 1638252473),
(224, 4, 'Nón Lưỡi Trai UV MHA 1015', 'Nón Lưỡi Trai UV MHA 1015 là phụ kiện thời trang không thể thiếu trong tủ đồ của cả nam lẫn nữ. Nón lưỡi trai không chỉ giúp che nắng mà còn là điểm nhấn cho các set đồ của bạn thêm cá tính.\r\n\r\nChất liệu: Thun UV. \r\nForm dáng: Nón Lưỡi Trai.\r\nMàu sắc: Xám, Xanh Đậm, Cam Đậm. \r\nSản xuất: Việt Nam', '169000.00', '0.000', 0, 'nonluoitrai_nam.jpg', '[\"nonluoitrai_nam02.jpg\"]', 0, 0, 4, 1, 1640003232),
(85, 2, 'VÁY BÚT CHÌ 1 NÚT', 'Váy bút chì 1 nút\r\n- Tên Sản Phẩm: Váy bút chì 1 nút\r\n- Giá Bán: 275,000vnđ\r\n- Số Đo Eo: 62CM\r\n- Số Đo Mông: 86CM\r\n- Số Đo Xẻ Sau: 19CM\r\n- Chiều Dài Chân Váy: 59CM\r\n- Thông Số Size: XS\r\n- Chất Liệu Vải: THUN 4 Chiều\r\n- Co Giãn Tốt\r\n- Có 1 Lớp\r\n- Không Có Túi\r\n*CHÂN VÁY BÚT CHÌ, LƯNG LIỀN, PHẦN LƯNG CÓ ĐAI TẠO KIỂU, Ở ĐAI CÓ ĐÍNH 1 NÚT NHỰA ĐỂ CỐ ĐỊNH ĐAI VÀO CHÂN VÁY, PHẦN LAI SAU CÓ XẺ TÀ, DÂY KÉO PHÍA SAU.', '275000.00', '192500.000', 82500, 'chanvay_butchi_one_01.jpg', '[\"chanvay_butchi_one_02.jpg\"]', 0, 1, 4, 1, 1638252359),
(219, 4, 'Vớ Nam MSO 1008', 'Vớ Nam MSO 1008 vớ cổ cao, vải thun \r\n\r\nChất liệu: Thun cotton.\r\nMàu Sắc : Đen, Trắng\r\nGiới tính: Nam. \r\nSản xuất : Việt Nam.', '69000.00', '0.000', 0, 'vonam.jpg', '[]', 0, 0, 4, 1, 1640003109),
(82, 2, 'CHÂN VÁY RÚT DÂY', 'Chân váy rút dây\r\n- Tên Sản Phẩm: Chân váy rút dây\r\n- Giá Bán: 295,000vnđ\r\n- Màu Sắc: Đen\r\n- Số Đo Eo: 66CM\r\n- Số Đo Mông: 82CM\r\n- Chiều Dài Chân Váy: 44CM\r\n- Thông Số Size: S\r\n- Chất Liệu Vải: TUYẾT HÀN\r\n- Có Quần Lớp Trong\r\n- Không Có Túi\r\n*CHÂN VÁY FORM ÔM, BẢN LƯNG KHOẢNG 4CM, BÊN TRÁI CÓ RÚT DÂY, PHẦN RÚT DÂY CÓ THỂ ĐIỀU CHỈNH DÀI NGẮN TÙY THEO Ý KHÁCH DÂY KÉO PHÍA SAU', '295000.00', '0.000', 0, 'chanvay_rutday_one_01.jpg', '[\"chanvay_rutday_one_02.jpg\"]', 0, 0, 4, 1, 1638252074),
(83, 2, 'CHÂN VÁY XÒE PHỐI NÚT', 'Chân váy xòe phối nút\r\n- Tên Sản Phẩm: Chân váy xòe phối nút \r\n- Giá Bán: 365,000vnđ\r\n- Màu Sắc: Hồng\r\n- Số Đo Eo: 65\r\n- Chiều Dài Chân Váy: 67\r\n- Thông Số Size: S\r\n- Chất Liệu Vải:\r\nLỚP CHÍNH: COTTON HẠT\r\nLỚP LÓT: LÓT LỤA\r\n- Có 2 Lớp\r\n- Không Có Túi\r\n*CHÂN VÁY FORM XÒE, BẢN LƯNG KHOẢNG 5.5CM, PHẦN EO Ở GIỮA TRƯỚC CÓ KHOÉT TẠO KIỂU, GIỮA CHÂN VÁY CÓ NÚT BỌC TẠO ĐIỂM NHẤN, CHÂN VÁY XẾP LY NHÚN Ở PHẦN LƯNG TẠO ĐỘ XÒE, DÂY KÉO PHÍA SAU', '365000.00', '328500.000', 36500, 'chanvay_xoe_one_01.jpg', '[\"chanvay_xoe_one_02.jpg\"]', 0, 0, 4, 1, 1638252171),
(222, 4, 'Vớ Nam MSO 1008', 'Vớ Nam MSO 1008 vớ cổ cao, vải thun \r\n\r\nChất liệu: Thun cotton.\r\nMàu Sắc : Đen, Trắng\r\nGiới tính: Nam. \r\nSản xuất : Việt Nam.', '69000.00', '0.000', 0, 'vonam.jpg', '[]', 0, 0, 4, 1, 1640003109),
(223, 1, 'Quần Spandex Joggers Nam', 'Chất liệu chân cua 100% cotton, co dãn và thấm hút mồ hôi tốt', '315000.00', '0.000', 0, '3abbdd0db45ac0b6319ecd9a6e860d3f.png', '[\"3abbdd0db45ac0b6319ecd9a6e860d3f1.png\"]', 0, 0, 4, 1, 1640003189),
(79, 2, 'ÁO JACKET THỂ THAO NỮ LIVAN EMPOWER', '*Chất liệu: 95% Polyamide & 5% Spandex co giãn\r\n*Đặc điểm:\r\n- Chất liệu cao cấp, không thô ráp, mềm mại, thoải mái, co giãn, hỗ trợ tối đa các hoạt động thể chất \r\n- 2 lớp dày dặn nhưng thoáng khí, nhẹ nhàng: một lớp vải gió cao cấp, một lớp lưới\r\n- Mặc được hai kiểu bo và suông với dây rút điều chỉnh độ rộng\r\n- Khóa được thiết kế riêng bởi SBS-nhà cung cấp khóa hàng đầu thế giới, có viền che thanh lịch,  chống trượt khóa\r\n- 2 túi có khoá 2 bên tiện dụng, an toàn\r\n- Tay áo được bo viền gọn gàng để cản gió\r\n - Mũ áo có thể điều chỉnh độ rộng, giữ ấm và tiện lợi \r\n - Hình in công nghệ cao tạo thêm nét khỏe khoắn, năng động', '868000.00', '781200.000', 86800, 'aothethao_one_01.jpg', '[\"aothethao_one_02.jpg\"]', 0, 0, 4, 1, 1638251802),
(220, 5, 'Chân Váy A Nữ Xẻ Tam Giác WSK 4017', 'Chân Váy A Nữ Xẻ Tam Giác WSK 4017 với đường xẻ tạo cảm giác thoải mái khi di chuyển. Bộ màu đa dạng, dễ dàng chọn lựa để phối.\r\n\r\nChất liệu: Jean\r\nForm: Chữ A\r\nMàu sắc: Trắng, xanh đen, đỏ\r\nSản xuất: Việt Nam', '359000.00', '199000.000', 160000, 'chanvayanu_xetamgiac.jpg', '[\"chanvayanu_xetamgiac02.jpg\"]', 0, 0, 4, 1, 1640003018),
(221, 1, 'Quần Thể Thao Jogger Nam', 'Chất Vải Gió Cao Cấp, Siêu Nhẹ, Chống Nhăn, Giữ Ấm Tốt (QGD21014)', '219000.00', '0.000', 0, '7821f5bad05e49dab67356b720aeb9eb.png', '[\"7821f5bad05e49dab67356b720aeb9eb1.png\"]', 0, 0, 4, 1, 1640003049),
(217, 5, 'Chân Váy A Nữ Xẻ Tam Giác WSK 4017', 'Chân Váy A Nữ Xẻ Tam Giác WSK 4017 với đường xẻ tạo cảm giác thoải mái khi di chuyển. Bộ màu đa dạng, dễ dàng chọn lựa để phối.\r\n\r\nChất liệu: Jean\r\nForm: Chữ A\r\nMàu sắc: Trắng, xanh đen, đỏ\r\nSản xuất: Việt Nam', '359000.00', '199000.000', 160000, 'chanvayanu_xetamgiac.jpg', '[\"chanvayanu_xetamgiac02.jpg\"]', 0, 0, 4, 1, 1640003018),
(77, 2, 'ĐẦM 2 DÂY BODY', 'Đầm 2 dây body\r\n- Tên Sản Phẩm: Đầm 2 dây body\r\n- Giá Bán: 520,000vnđ\r\n- Màu Sắc: ĐEN\r\n- Số Đo Ngực: 82CM\r\n- Số Đo Eo: 62CM\r\n- Số Đo Dài Tay: 35CM\r\n- Chiều Dài Đầm: 108CM\r\n- Thông Số Size: XS\r\n- Số Size: XS, S, M, L, XL\r\n- Chất Liệu Vải: THUN VÂN GỖ\r\n- Có 1 Lớp\r\n- Không Có Túi\r\n*ĐẦM FORM BÚT CHÌ, 2 DÂY, DÂY KHÔNG TĂNG ĐƠ , TRƯỚC NGỰC CÓ PHẦN BÈO TRỄ VAI TẠO KIỂU, ĐẦM RÃ CÚP Ở NGỰC, RÃ EO, ĐẦM CÓ MÚT NGỰC, DÂY KÉO PHÍA SAU.', '520000.00', '260000.000', 260000, 'damday_one_01.jpg', '[\"damday_one_02.jpg\"]', 0, 0, 4, 1, 1638251587),
(78, 2, 'ĐẦM SƠ MI THẮT EO', 'Đầm sơ mi thắt eo\r\n- Tên Sản Phẩm: Đầm sơ mi thắt eo\r\n- Giá Bán: 495,000vnđ\r\n- Màu Sắc: XANH\r\n- Số Đo Ngực: 90CM\r\n- Số Đo Dài Tay: 52CM\r\n- Số Đo Cửa Tay: 18CM\r\n- Số Đo Vai: 36CM\r\n- Chiều Dài Đầm: 101CM\r\n- Thông Số Size: XS\r\n- Số Size: XS, S, M, L, XL\r\n- Chất Liệu Vải: COTTON SỌC\r\n*ĐẦM SƠ MI FORM SUÔNG, NÚT LÀ NÚT CHẾT KHÔNG THÁO MỞ ĐƯỢC. TAY DÀI PHỐI MĂNG SẾT, BẢN MĂNG SẾT KHOẢNG 9.5CM CÓ NÚT NHỰA, XẾP LY NHÚN Ở CỬA TAY, THÂN SAU CÓ RÃ ĐÔ, XẾP LY Ở GIỮA ĐÔ THÂN SAU, ĐẦM KÈM DÂY ĐAI THẮT EO CÓ THỂ THÁO RỜI, ĐẦM KHÔNG DÂY KÉO.', '495000.00', '247500.000', 247500, 'somithateo_one_01.jpg', '[\"somithateo_one_02.jpg\"]', 0, 0, 4, 1, 1638251666),
(218, 1, 'Quần Thể Thao Jogger Nam', 'Chất Vải Gió Cao Cấp, Siêu Nhẹ, Chống Nhăn, Giữ Ấm Tốt (QGD21014)', '219000.00', '0.000', 0, '7821f5bad05e49dab67356b720aeb9eb.png', '[\"7821f5bad05e49dab67356b720aeb9eb1.png\"]', 0, 0, 4, 1, 1640003049),
(74, 2, 'ĐẦM BODY CỔ V ĐẮP', 'Đầm body cổ V đắp\r\n- Tên Sản Phẩm: Đầm body cổ V đắp \r\n- Giá Bán: 495,000vnđ\r\n- Màu Sắc: Đen, Hồng\r\n- Số Đo Ngực: 80CM\r\n- Số Đo Eo: 61CM\r\n- Số Đo Mông: 88CM\r\n- Số Đo Vai: 33CM\r\n- Số Đo Hạ V: 16.5CM\r\n- Số Đo Dài Tay: 13CM\r\n- Số Đo Cửa Tay: 25CM\r\n- Số Đo Dài Đầm: 90CM\r\n- Thông Số Size: XS\r\n- Chất Liệu Vải:\r\n- LỚP CHÍNH: COTTON MISA\r\n- LỚP LÓT: LỤA\r\n- Có 2 Lớp\r\n- Không Có Túi', '495000.00', '445500.000', 49500, 'dambody_one_01.jpg', '[\"dambody_one_02.jpg\"]', 0, 0, 4, 1, 1638251325),
(75, 2, 'ĐẦM REN TAY ĐÍNH NƠ', 'Đầm ren tay đính nơ\r\n- Tên Sản Phẩm: Đầm ren tay đính nơ \r\n- Giá Bán: 590,000vnđ\r\n- Màu Sắc: TRẮNG, ĐEN\r\n- Số Đo Ngực: 88CM\r\n- Số Đo Eo: 68CM\r\n- Số Đo Vai: 33CM\r\n- Số Đo Dài Tay: 34CM\r\n- Số Đo Cửa Tay: 26CM\r\n- Chiều Dài Đầm: 102CM\r\n- Thông Số Size: S\r\n- Số Size XS-S-M-L-XL\r\n- Chất Liệu Vải: REN\r\n- Có 2 Lớp\r\n- Không Có Túi\r\n*ĐẦM FORM A XÒE CƠ BẢN, CỔ TRÒN, TAY LỞ, CỬA TAY CÓ ĐÍNH DÂY NƠ TẠO KIỂU, ĐẦM RÃ CÚP Ở NGỰC, RÃ EO, DÂY KÉO PHÍA SAU.', '590000.00', '295000.000', 295000, 'damren_one_01.jpg', '[\"damren_one_02.jpg\"]', 0, 0, 4, 1, 1638251434),
(73, 2, 'ĐẦM DÂY ĐẮP CHÉO TÀ', 'Đầm dây đắp chéo tà\r\n- Tên Sản Phẩm: Đầm dây đắp chéo tà\r\n- Giá Bán: 480,000vnđ\r\n- Màu Sắc: BE\r\n- Số Đo Ngực: 84CM\r\n- Số Đo Eo: 66CM\r\n- Số Đo Dài Dây: 53CM\r\n- Số Đo Hạ V: 12CM\r\n- Chiều Dài Đầm: 90CM\r\n- Thông Số Size S\r\n- Số Size XS, S, M, L\r\n- Chất Liệu Vải: THUN VÂN GỖ\r\n- Có 1 Lớp\r\n- Không Có Túi\r\n*ĐẦM 2 DÂY FORM BÚT CHÌ, CỔ V, PHẦN NÁCH 2 BÊN THIẾT KẾ CÁCH ĐIỆU TẠO KIỂU, ĐẦM RÃ EO, PHẦN TÙNG VÁY ĐẮP CHÉO TÀ TỪ BÊN PHẢI QUA BÊN TRÁI, DÂY KÉO PHÍA SAU.', '480000.00', '144000.000', 336000, 'vayday_one_01.jpg', '[\"vayday_one_02.jpg\",\"vayday_one_03.jpg\"]', 0, 0, 4, 1, 1638251178),
(72, 4, 'GIÀY MỌI NAM', 'Giày mọi nam MWC NAMO- 6631\r\nChất liệu: Da tổng hợp\r\nKiểu dáng: Giày lười\r\nMàu sắc: Đen/ Nâu\r\n- Điểm nổi bật:  Sản phẩm hoàn hảo từ thiết kế, kiểu dáng cho tới chất liệu. Chất da nguyên miếng nhập khẩu tạo nên vẻ bóng lì rất hút mắt và sang trọng khi đặt cạnh những chất da khác. Từng đường kim mũi chỉ trên thân giày đều đặn, chắc chắn, cho độ bền ở mức cao nhất. Đế giày kết hợp cao su chóng trơn trượt và đế phíp đẳng cấp đẹp mắt. \r\n- Điểm khác biệt: Sản phẩm Giày mọi nam MWC NAMO- 6631 mang vẻ đẹp đầy quyền uy mà vẫn thời thượng, hiện đại. Khi sử dụng, bạn sẽ cực kỳ tự tin với một đôi giày êm chân và không gây bức bí khó chịu. \r\n- Mix đồ: Thiết kế này rất \"dễ tính\" khi phối đồ. Bạn có thể mix giày cùng trang phục trẻ trung như sơ mi dáng ôm và quần chinos có độ dài trên mắt cá chân. Những bộ suit may đo lịch lãm cũng sẽ thêm phần hiện đại khi được phối cùng sản phẩm này.', '235000.00', '211500.000', 23500, 'giaymoi_one_021.png', '[\"giaymoi_one_02.png\"]', 0, 0, 4, 1, 1638211576),
(232, 6, 'Áo hoodie trơn màu đen', 'Hoodie unisex form rộng là 1 sản phẩm phù hợp cho cả nam và nữ, thích hợp là chiếc áo cặp cho các cặp đôi', '335000.00', '0.000', 0, '5c9a367cb497a9c79ad499b7ffafe927.jpg', '[\"5c9a367cb497a9c79ad499b7ffafe9271.jpg\"]', 0, 0, 4, 1, 1640003741),
(71, 4, 'GIÀY THỂ THAO NAM', 'Giày Thể Thao Nam MWC NATT - 5320 với chất vải Flyknit chuyên dụng tạo cảm giác thoải mái cho bạn trong suốt quá trình vận động. Kiểu dáng và màu sắc hiện đại mang lại một phong cách thật thời thượng mỗi khi xuống phố. Sản phẩm có thiết kế tinh tế cùng đường may tỉ mỉ, chắc chắn, thích hợp trong các hoạt động thể thao, dạo chơi, picnic,...\r\nĐặc điểm sản phẩm\r\n- Chất vải chuyên dụng trong thể thao.\r\n- Công nghệ thấm hút mồ hôi, giúp giữ mát và khô ráo suốt ngày.\r\n- Tạo cảm giác thoải mái trong suốt quá trình vận động.\r\n- Thiết kế trẻ trung, năng động.\r\n- Sử dụng tốt nhất đối với: hoạt động bình thường tại phòng tập Gym, trang phục tiện dụng', '250000.00', '225000.000', 25000, 'giaythethao_one_01.png', '[\"giaythethao_one_02.png\"]', 0, 0, 4, 1, 1638211490),
(230, 1, 'Áo Khoác Nam 2 Lớp Trần Lông', 'Chất liệu: Áo 2 Lớp Trần Lông. Màu sắc: Xanh Than - Xanh Ngọc-Xám-Vàng', '299000.00', '0.000', 0, '407ce9bde916c08df370c3aa75490e77.jpg', '[\"407ce9bde916c08df370c3aa75490e771.jpg\"]', 0, 0, 4, 1, 1640003626),
(231, 5, 'Áo Thun Nữ WTS 2017', 'Áo Thun Nữ WTS 2017 có thiết kế trơn đơn giản với màu sắc tươi mới, thích hợp cho những bạn trẻ năng động, cá tính. Chất liệu vải cotton mang đến sự thoải mái khi mặc, từng mối chỉ đường kim được gia công kỹ lưỡng chắc chắn.\r\n\r\nChất liệu: Cotton. \r\nMàu sắc: Nâu nhạt\r\nKiểu dáng: Slim\r\nThông điệp “Believe in yourself and you will be unstoppable” được thêu nổi bật giữa ngực áo.\r\nSản xuất: Việt Nam ', '219000.00', '109500.000', 109500, 'aothunnu_wts.png', '[\"aothunnu_wts02.png\"]', 0, 0, 4, 1, 1640003685),
(273, 1, 'Quần Jean Nam cao cấp', 'Quần Jean Nam cao cấp co dãn 4 chiều Thương Hiệu Chandi, phong cách hàn quốc trẻ trung cá tính MR9011', '192000.00', '0.000', 0, '7bcdbe2b1bdc8df7f0675170de92d1362.jpg', '[]', 0, 0, 4, 1, 1640057383),
(228, 5, 'Áo Thun Nữ Dây Kéo WTS 2011', 'Áo Thun Nữ Dây Kéo WTS 2011 với thông điệp tận hưởng những chuyến trải nghiệm (Enjoy the adventures), dây kéo bên eo tạo điểm nhấn lạ mắt.\r\n\r\nMàu sắc: Trắng, Đen, Cam đất\r\nChất liệu: Cotton\r\nKiểu dáng: Regular, form áo giấu quần phá cách.\r\nSản xuất: Việt Nam ', '299000.00', '139000.000', 160000, 'aothunnu_daykeo.jpg', '[\"aothunnu_daykeo02.jpg\",\"aothunnu_daykeo03.jpg\"]', 0, 0, 4, 1, 1640003520),
(229, 6, 'Áo khoác nam dù nam có nón', 'Áo khoác nam dù nam có nón cao cấp phong cách Hàn Quốc áo chống nắng tiện lợi', '209000.00', '0.000', 0, 'af06d30691d7a117167ccff7bb42da68.jpg', '[\"af06d30691d7a117167ccff7bb42da681.jpg\"]', 0, 0, 4, 1, 1640003528),
(225, 1, 'ÁO KHOÁÁO KHOÁC DÙ NAMC DÙ NAM', 'ÁO GIÓ LÓT LÔNG CỪU NAM NỮ- CHẤT LIỆU LÔNG MỀM MỊN VÀ CHẤT GIÓ CHỐNG NƯỚC 100%', '285000.00', '0.000', 0, '51156dfc24145339d1774a4bea433cbf.jpg', '[\"51156dfc24145339d1774a4bea433cbf1.jpg\"]', 0, 0, 4, 1, 1640003316),
(226, 4, 'Túi Bao Tử In Retro FUTURISTIC MBA 1010', 'Túi Bao Tử In Retro FUTURISTIC MBA 1010  Thiết kế thời trang, trẻ trung.\r\n\r\nChất liệu : Dù\r\nMàu Sắc : Đen. \r\nGiới tính: Unisex. \r\nSản xuất : Việt Nam.', '349000.00', '0.000', 0, 'tuibaotu.jpg', '[]', 0, 0, 4, 1, 1640003324),
(67, 1, 'ÁO POLO NAM ARISTINO APL003', 'KIỂU DÁNG: REGULAR FIT\r\nCHI TIẾT:\r\n- Áo polo phom Regular Fit suông nhẹ thoải mái mà vẫn vừa vặn tôn dáng.\r\n- Thiết kế basic với cổ dệt lịch sự. Màu sắc nam tính dệt jacquard họa tiết mang đến cho người mặc diện mạo tinh tế và thu hút.\r\nCHẤT LIỆU:\r\n- Chất liệu 100% Polyester mang đến độ bóng sắc nét, không bị bai dão, luôn bền màu. Áo còn có khả năng chống bám bụi, chống nhăn, hạn chế thấm nước, độ bền cao.\r\nMÀU SẮC: Xanh tím than 12\r\nSIZE: M – L – XL – XXL', '550000.00', '495000.000', 55000, 'aopolo_three_01.jpg', '[]', 0, 0, 4, 1, 1638211039),
(65, 1, 'ÁO POLO NAM ARISTINO APL001', '\"KIỂU DÁNG: GOLF FIT\r\nCHI TIẾT:\r\n- Áo Polo phom Golf fit suông vừa, số đo được tinh chỉnh phù hợp hoàn hảo với người chơi golf và những quý ông ưa vận động.\r\n- Cổ dệt rib kẻ ngang ở ngoài, nẹp ở trong, kết hợp đường line được ép seam trên cầu vai, mang đến điểm nhấn ấn tượng.\r\nCHẤT LIỆU:\r\n- 97% Nylon cho bề mặt vải độ mịn mượt, mỏng nhẹ.\r\n- 3% Spandex Funmax tạo độ co giãn nhẹ, đồng thời có khả năng kháng khuẩn, kháng UV, bảo vệ người mặc tối đa.\r\nMÀU SẮC: Hồng 1, Trắng 6\r\nSIZE: M - L - XL -XXL\"', '750000.00', '675000.000', 75000, 'aopolo_one_01.jpg', '[\"aopolo_one_02.jpg\"]', 0, 0, 4, 1, 1638210873),
(62, 1, 'ÁO THUN DÀI TAY NAM ARISTINO ATD001', 'KIỂU DÁNG: SLIM FIT\r\nCHI TIẾT:\r\n- Áo T-shirt dài tay phom Slim fit ôm vừa vặn, đồng thời vẫn đảm bảo sự thoải mái trong từng chuyển động.\r\n- Áo thiết tinh giản với 2 gam màu trung tính, chữ ký Aristino được in trước ngực tinh tế, tạo điểm nhấn ấn tượng khi mặc\r\nCHẤT LIỆU:\r\n- 48% Cotton giúp áo mềm mại, xốp nhẹ và thoáng khí.\r\n- 47% Polyester cho bề mặt vải bóng mịn, sắc nét, ít nhăn co.\r\n- 5% Spandex tạo độ co giãn nhẹ.\r\nMÀU SẮC: Booc đô 15MF, Xám 26MF', '395000.00', '355500.000', 39500, 'aothuntaydai_two_01.jpg', '[\"aothuntaydai_two_02.jpg\"]', 0, 0, 4, 1, 1638210470),
(63, 1, 'ÁO THU ĐÔNG NAM ARISTINO ATD002', 'KIỂU DÁNG: REGULAR FIT\r\nCHI TIẾT:\r\n- Áo Swear Shirt phom Regular fit suông vừa, thoải mái tuyệt đối khi mặc.\r\n- Áo thiết kế cổ tròn basic, màu sắc trung tính, đem đến nhiều lựa chọn kết hợp trang phục khác nhau.\r\nCHẤT LIỆU:\r\n- 95% Polyester giúp áo bền màu, sắc nét, mặt vải trơn trượt, mỏng nhẹ.\r\n- 5% Spandex tạo độ co giãn nhẹ.\r\nMÀU SẮC: Xanh tím than 26, Trắng 6\r\nSIZE: S - M - L - XL - XXL', '550000.00', '495000.000', 55000, 'aothuntaydai_one_01.jpg', '[\"aothuntaydai_one_02.jpg\"]', 0, 0, 4, 1, 1638210612),
(64, 1, 'ÁO SWEATSHIRT DÀI TAY ARISTINO ATD003', 'KIỂU DÁNG: REGULAR FIT\r\nCHI TIẾT:\r\n- Áo Swear Shirt dáng Regular Fit suông nhẹ, thoải mái.\r\n- Thiết kế cổ tròn basic, bo viền cổ tay và gấu áo. Mặt trước in họa tiết đặc trưng của thiên nhiên vùng Tây Bắc kết hợp in và dệt chữ độc đáo. Màu sắc nam tính kết hợp hiệu ứng màu melange mang diện mạo thu hút cho người mặc.\r\nCHẤT LIỆU:\r\n- Chất liệu cotton tự nhiên mềm mại, xốp nhẹ kết hợp Polyester giúp bề mặt vải bền chắc, mượt và có độ bóng sắc nét. Áo dễ làm sạch và dễ bảo quản, bền màu và giữ nguyên định hình sau nhiều lần giặt. Áo có độ co giãn thoải mái nhờ sợi spandex.\r\nMÀU SẮC:  Xám 26M, Xanh biển 87MF\r\nSIZE:  S – M – L – XL – XXL', '565000.00', '282500.000', 282500, 'aothuntaydai_three_01.jpg', '[\"aothuntaydai_three_02.jpg\"]', 0, 0, 4, 1, 1638210748),
(61, 1, 'ÁO LEN NAM ARISTINO AL003', 'KIỂU DÁNG: REGULAR FIT\r\nCHI TIẾT:\r\n- Áo len cổ kéo khóa phom dáng Regular Fit suông nhẹ, thoải mái và ấm áp.\r\n- Thiết kế basic với cổ cao có khóa kéo kết hợp hiệu ứng dệt bo rib ở cổ tay, gấu áo ôm sát gọn gàng, dễ dàng vận động, giữ ấm tốt hơn; Thích hợp mặc đi làm, du lịch, dạo phố,...\r\nCHẤT LIỆU:\r\n- Chất liệu len Acrylic nhẹ, ấm, hạn chế xù lông. Đặc biệt co giãn, đàn hồi và giữ định hình tốt. Áo có khả năng kiểm soát ẩm tốt, thoáng, vẫn giữ ấm cơ thể nhưng không bí.\r\n- Kết hợp cotton mềm mịn, xốp nhẹ, dễ chịu với da.\r\nMÀU SẮC: Xám 108M, Xám 234M, Xanh tím than 54, Xanh rêu 71\r\nSIZE:  S – M – L – XL ', '795000.00', '397500.000', 397500, 'aolen_three_01.jpg', '[\"aolen_three_02.jpg\",\"aolen_three_03.jpg\",\"aolen_three_04.jpg\"]', 0, 0, 4, 1, 1638210021),
(60, 1, 'ÁO LEN NAM ARISTINO AL002', 'KIỂU DÁNG: CASUAL FIT\r\nCHI TIẾT:\r\n- Áo len phom Casual fit trẻ trung và phóng khoáng với thiết kế cổ tròn, dệt bo cổ, tay và gấu áo mang đến sự khỏe khoắn.\r\n- Áo có 2 màu sắc tươi trẻ và không kén người mặc là kem và xanh tím than,được nhấn nhá bởi những mảng màu thú vị trên 2 hiệu ứng dệt khác nhau.\r\nCHẤT LIỆU:\r\n- Với thành phần chính là sợi Acrylic, áo len AWO004W9 nhẹ, ấm, hạn chế xù lông, có khả năng đàn hồi và giữ định hình tốt. Áo kiểm soát ẩm tốt, thoáng, vẫn giữ ấm cơ thể nhưng không gây cảm giác bí bách.\r\nMÀU SẮC: Be 31, Xanh tím than 179\r\nSIZE:  S – M – L – XL', '650000.00', '325000.000', 325, 'aolen_two_01.jpg', '[\"aolen_two_02.jpg\"]', 0, 0, 4, 1, 1638209897),
(59, 1, 'ÁO LEN NAM ARISTINO AL001', 'KIỂU DÁNG: REGULAR FIT\r\nCHI TIẾT:\r\n- Áo len nam phom Regular fit suông nhẹ, vừa vặn với cơ thể, đem lại cảm giác thoải mái, tự do khi mặc.\r\n- Thiết kế đơn giản và tinh tế thích hợp với những người yêu thích vẻ đẹp tối giản, gam màu trung tính dễ dàng kết hợp nhiều trang phục\r\nCHẤT LIỆU:\r\n- 55% sợi Acrylic đem tới sự ấm áp tuyệt vời đồng thời vẫn có bề mặt vải êm nhẹ.\r\n- 45% Cotton giúp áo mềm mại, xốp nhẹ và thoáng khí.\r\nMÀU SẮC: Xanh biển 102, Xám 229, Cam 35, Xanh tím than 23\r\nSIZE: S - M - L - XL - XXL', '650000.00', '585000.000', 65000, 'aolen_one_01.jpg', '[\"aolen_one_021.jpg\",\"aolen_one_03.jpg\",\"aolen_one_04.jpg\"]', 0, 0, 4, 1, 1638209793),
(58, 1, 'ÁO SƠ MI NGẮN TAY NAM ARISTINO ASM003', 'KIỂU DÁNG: REGULAR FIT - TÀ LƯỢN\r\nCHI TIẾT:\r\n- Áo sơ mi ngắn tay phom Regular Fit suông vừa.\r\n- Áo thiết kế tà lượn, có túi ngực, màu trắng in họa tiết chấm thanh lịch.\r\nCHẤT LIỆU:\r\n- 51% Modal cho bề mặt vải mềm mại, nhẹ và thoáng khí.\r\n- 47% Polyester giúp áo bền màu, sắc nét và độ trơn trượt, mỏng nhẹ\r\n- 2% Spandex tạo độ co giãn nhẹ\r\nMÀU SẮC: Trắng in họa tiết chấm\r\nSIZE:  38 – 39 – 40 – 41 – 42 – 43', '725000.00', '652500.000', 72500, 'somi_three_01.jpg', '[]', 0, 0, 4, 1, 1638209693),
(53, 1, 'ÁO KHOÁC NAM ARISTINO AK002', 'KIỂU DÁNG: REGULAR FIT\r\nCHI TIẾT:\r\n- Áo khoác lông vũ phom Regular fit suông vừa, nhẹ ấm mang đến cảm giác thoải mái tuyệt đối cho người mặc,\r\n- Thiết kế khỏe khoắn, đường may chắc chắn, màu sắc cơ bản, dễ kết hợp với các trang phục khác nhau.\r\nCHẤT LIỆU:\r\n- 100% Polyamide giúp kết cấu bề mặt vải bền chắc, sắc nét, mềm mịn, thoáng khí với khả năng thấm hút mồi hôi và thoát ẩm vượt trội\r\nMÀU SẮC: Xám 218, Đen 1, Xanh tím than 41\r\nSIZE: S - M - L - XL - XXL', '1950000.00', '1755000.000', 195000, 'aokhoac_two_01.jpg', '[\"ackhoac_two_02.jpg\",\"aokhoac_two_031.jpg\"]', 0, 0, 4, 1, 1637983707),
(52, 1, 'ÁO KHOÁC NAM ARISTINO AK001', 'KIỂU DÁNG: REGULAR FIT\r\nCHI TIẾT:\r\n- Áo khoác 2 lớp phom Regular fit suông nhẹ, phù hợp với mọi vóc dáng, đem lại cảm giác thoải mái tự tin khi mặc.\r\n- Áo thiết kế cổ dựng nam tính, bo tay bo gấu thời trang, thêu chữ ký Aristino trước ngực tạo điểm nhấn tinh tế, thời trang.\r\nCHẤT LIỆU:\r\n- 100% Polyester giúp áo bền màu, sắc nét, mặt vải trơn trượt, mỏng nhẹ. Ngoài ra áo còn có khả năng chống bám bụi, chống nhăn, hạn chế thấm nước, độ bền cao.\r\nMÀU SẮC: Xám 40MF, Đen 9\r\nSIZE: S - M - L - XL -XXL', '1200000.00', '1080000.000', 120000, 'aokhoac_one_01.jpg', '[\"aokhoac_one_02.jpg\"]', 0, 0, 4, 1, 1637983415),
(29, 1, 'QUẦN KAKI THUN JOGGER', 'Kiểu dáng trẻ trung, tông màu, họa tiết lạ mắt dễ dàng mix cùng áo thun tạo phong cách trẻ trung cho bạn trẻ.\r\n\r\nThiết kế túi 2 bên tiện dụng, bo lưng thun giúp bạn thoải mái khi vận động.\r\n\r\nForm dáng dài, chất liệu bố, dày dặn, thấm hút mồ hôi bạn trai có thể thoải mái hoạt động\r\nSize : M, L\r\n', '300000.00', '180000.000', 120000, 'cu-cai-quan-kaki-thun-jogger-thoi-trang-mau-kem-qg06-1m4G3-7ec3c2_simg_d0daf0_800x1200_max.jpg', '[\"cu-cai-quan-kaki-thun-jogger-thoi-trang-mau-kem-qg06-1m4G3-3e0554_simg_d0daf0_800x1200_max.jpg\",\"cu-cai-quan-kaki-thun-jogger-thoi-trang-mau-kem-qg06-1m4G3-63841e_simg_d0daf0_800x1200_max.jpg\",\"cu-cai-quan-kaki-thun-jogger-thoi-trang-mau-kem-qg06-1m4G3-fd6df6_simg_d0daf0_800x1200_max.jpg\"]', 27, 2, 4, 1, 1493983674),
(28, 1, 'QUẦN KAKI NAM LỊCH LÃM - D36', 'Quần kaki nam lịch lãm\r\n\r\nChất liệu vải kaki loại 1 dày mịn\r\nCó đủ size 28,29,30,31,32\r\n\r\nVới 3 tông màu trầm đen,xanh đen rất dễ phối với áo thun,áo sơ mi,...tạo phong cách thanh lịch cho các bạn nam khi diện đến công sở, đi chơi,du lịch,...\r\n', '169000.00', '100000.000', 69000, 'quan-kaki-nam-lich-lam-1m4G3-NvjQo7_simg_d0daf0_800x1200_max.jpg', '[\"quan-kaki-nam-lich-lam-1m4G3-tyzFof_simg_d0daf0_800x1200_max.png\",\"quan-kaki-nam-lich-lam-1m4G3-uSjiJP_simg_d0daf0_800x1200_max.jpg\"]', 16, 2, 18, 4, 1493983674),
(27, 1, 'Quần short kaki nam - QKN44', 'Quần short Kaki Nam\r\n\r\nVải kaki loại 1, form chuẩn tôn dáng  \r\n\r\nSize: 28-32\r\n', '200000.00', '160000.000', 40000, 'quan-short-kaki-nam-1m4G3-sexFoa_simg_d0daf0_800x1200_max.jpg', '[\"quan-short-kaki-nam-1m4G3-E4MW4M_simg_d0daf0_800x1200_max.jpg\",\"quan-short-kaki-nam-1m4G3-iKaEX7_simg_d0daf0_800x1200_max.jpg\",\"quan-short-kaki-nam-1m4G3-reyYEA_simg_d0daf0_800x1200_max.jpg\"]', 2, 1, 4, 1, 1493983674),
(26, 1, 'QUẦN KAKI SHORT NAM - QS43', 'Thông tin chi tiết sản phẩm\r\n\r\nTên sản phẩm : Quần kaki short nam cá tính-QS43\r\n\r\n Mã sản phẩm : QS43\r\n Chất liệu : vải kaki\r\n Mầu sắc : xanh đen,xanh dương, nâu vàng\r\n\r\n Kích cỡ :  28-29-30-31-32\r\n\r\nTrọng lượng : 400g\r\n', '165000.00', '115000.000', 50000, 'quan-kaki-short-nam-qs43-1m4G3-Czuekh_simg_d0daf0_800x1200_max.jpg', '[\"quan-kaki-short-nam-qs43-1m4G3-3TUeRm_simg_d0daf0_800x1200_max.jpg\",\"quan-kaki-short-nam-qs43-1m4G3-JsGgBd_simg_d0daf0_800x1200_max.jpg\",\"quan-kaki-short-nam-qs43-1m4G3-lqqiMY_simg_d0daf0_800x1200_max.jpg\"]', 5, 2, 9, 2, 1493983674),
(25, 1, 'ÁO NGẮN TAY CAO CẤP KIỂU DÁNG HÀN QUỐC', 'Sơ Mi Nam Ngắn Tay Cao Cấp</em> </strong>Kiểu dáng Hàn Quốc\r\n	Phom Dáng Slim Fix\r\n	Chất liệu 90% Cotton\r\n	Áo cao cấp, KHÔNG bai xù, mất phom sau thời gian dài sử dụng', '450000.00', '300000.000', 150000, 'so-mi-nam-ngan-tay-cao-cap-kieu-dang-han-quoc-1m4G3-8aLJTO_simg_d0daf0_800x1200_max.jpg', '[\"so-mi-nam-ngan-tay-cao-cap-kieu-dang-han-quoc-1m4G3-6pRF6s_simg_d0daf0_800x1200_max.jpg\",\"so-mi-nam-ngan-tay-cao-cap-kieu-dang-han-quoc-1m4G3-E232HF_simg_d0daf0_800x1200_max.jpg\",\"so-mi-nam-ngan-tay-cao-cap-kieu-dang-han-quoc-1m4G3-F3VBLA_simg_d0daf0_800x1200_max.jpg\"]', 2, 2, 9, 2, 1493983674),
(24, 1, 'PHONG CÁCH PHỐI MÀU', '	Chất Liệu: Kaki Silk Thun\r\n\r\nMàu Sắc: Cổ Trắng Phối Đen, Cổ Trắng Phối Xanh Đen, Cổ Đen Phối Trắng, Cổ Đen Phối Xanh Đen\r\n\r\nKiểu Dáng: Thiết Kế Dài Tay, Thân Phối Màu Trẻ Trung\r\nĐơn Vị: Cm\r\n\r\nKích Thước: Size L - Dài Áo: 67, Dài Tay: 60, Rộng Vai: 37 - 41, Vòng Ngực: 78 - 88 (Phù Hợp Với Bạn Nam Dưới 60kg, Chiếu Cao Dưới 1,65 mét)\r\nSize XL - Dài Áo: 69, Dài Tay: 60, Rộng Vai: 39 - 43, Vòng Ngực: 80 - 90 (Phù Hợp Với Bạn Nam Dưới 65kg, Chiếu Cao Dưới 1,7 mét)\r\nSize XXL - Dài Áo: 70, Dài Tay: 61, Rộng Vai: 40 - 44, Vòng Ngực: 82 - 92 (Phù Hợp Với Bạn Nam Dưới 70kg, Chiếu Cao Dưới 1,75 mét)\r\n', '230000.00', '160000.000', 70000, 'ao-so-mi-nam-phong-cach-phoi-mau-1m4G3-x9hhml.jpg', '[\"ao-so-mi-nam-phong-cach-phoi-mau-1m4G3-BSZiod.jpg\",\"ao-so-mi-nam-phong-cach-phoi-mau-1m4G3-xL4zQp.jpg\"]', 37, 1, 9, 2, 1493983674),
(23, 3, 'COMBO ĐẦM REN MÙA XUÂN', 'THÔNG TIN SẢN PHẨM \r\n\r\n- Chất liệu : REN\r\n\r\n- Năm sản xuất : 2016\r\n- Xuất xứ : Việt nam \r\n\r\n- Màu sắc :đỏ\r\n\r\n- Kích thước : Freesize từ 43-55k... size M từ 13-17. size L từ 17-25\r\n', '450000.00', '370000.000', 80000, 'combo-dam-ren-mua-xuan-cho-me-va-be-th08602-gs210-1m4G3-g4rMfx.jpg', '[\"combo-dam-ren-mua-xuan-cho-me-va-be-th08602-gs210-1m4G3-kwPno1.jpg\"]', 20, 8, 22, 5, 1493983674),
(21, 6, 'COMBO ĐÔI ĐẦM MẸ VÀ BÉ MICKEY', 'Tên sp: Combo áo thun mẹ và bé Mickey\r\n\r\nChất liệu: Thun cotton cá sấu cao cấp mềm mại thoải mai khi mặc cho các nàng\r\n\r\nMàu sắc:    Hồng - Trắng 2 màu 100% như hình ảnh minh họa. Gam màu trẻ trung cho các nàng\r\n\r\nThiết kế đơn giản kiểu đầm suông, form rộng , cổ tròn tay lỡ   phôi màu  trẻ trung xin xắn cho mẹ và bé\r\n\r\nPhù hợp với các mặt dao phố, du lịch, mặc nhà., đi làm, dự tiệc, event ...\r\n\r\nKích thước: Free Size\r\n\r\nCho bé từ 15 ---> 22 kg\r\n', '180000.00', '145000.000', 35000, 'combo-doi-dam-me-va-be-mickey-ddp08444-1.jpg', '[\"combo-doi-dam-me-va-be-mickey-ddp08444.jpg\",\"combo-doi-dam-me-va-be-mickey-ddp08444-1m4G.jpg\",\"combo-doi-dam-me-va-be-mickey-ddp08444-1m4G3-6653ea_simg_d0daf0_800x1200_max.jpg\"]', 1, 1, 4, 1, 1493983674),
(22, 5, 'COMBO ĐẦM CẶP MẸ VÀ BÉ', 'Set đôi mẹ và bé gồm :\r\nÁo dài tay + váy yếm cho mẹ cân nặng từ 43kg - 53kg\r\nÁo dài tay + quần yếm cho bé trai/ bé gái cân nặng từ 17kg- 24kg\r\nMàu sắc y hình\r\nChất cotton cao cấp dày mịn đẹp. Bao dày .\r\nShop ko ship hàng để xem hay lý do ko vừa ko thích ko hợp....\r\nTất cả sp đều có hình chụp đầy đủ nên khách vui lòng xem kỹ trước khi mua hàng bên shop\r\n', '400000.00', '300000.000', 100000, 'combo-dam-cap-me-va-be-1m4G3-epzjq8_simg_d0daf0_800x1200_max.jpg', '[\"combo-dam-cap-me-va-be-1m4G3-hKwaQm_simg_d0daf0_800x1200_max.jpg\",\"combo-dam-cap-me-va-be-1m4G3-SxVIlb_simg_d0daf0_800x1200_max.jpg\",\"combo-dam-cap-me-va-be-1m4G3-WqmKco_simg_d0daf0_800x1200_max.jpg\"]', 0, 1, 4, 1, 1493983674),
(20, 2, 'COMBO ĐẦM KÈM ÁO KHOÁC CHOÀNG', 'THÔNG TIN SẢN PHẨM \r\n\r\n- Chất liệu : thun\r\n- Năm sản xuất : 2016\r\n\r\n- Xuất xứ : Việt nam ( công ty thái hoàng sx)\r\n- Màu sắc : caro \r\n\r\n- Kích thước : Freesize dành cho mẹ từ 43-55kg - size M từ 13-17kg- L  từ 17-22kg\r\n \r\n', '380000.00', '290000.000', 90000, 'combo-dam-kem-ao-khoac-choang-thoi-trang-th08603-gs195-1m4G3-1SqJve.jpg', '[\"combo-dam-kem-ao-khoac-choang-thoi-trang-th08603-gs195-1m4G3-FWKQKq.jpg\"]', 32, 1, 4, 1, 1493983674),
(18, 2, 'ÁO VÁY GIA ĐÌNH AG0430 - AG0430', '', '900000.00', '650000.000', 250000, 'ao-vay-gia-dinh-ag0515-1m4G3-4UKwpv_simg_d0daf0_800x1200_max.jpg', '[\"ao-vay-gia-dinh-ag0515-1m4G3-pPlrtD_simg_d0daf0_800x1200_max.jpg\",\"ao-vay-gia-dinh-ag0515-1m4G3-t5DoaE_simg_d0daf0_800x1200_max.jpg\"]', 2, 1, 5, 1, 0),
(19, 3, 'COMBO ĐẦM ĐÔI PENDI XINH XẮN', 'THÔNG TIN SẢN PHẨM \r\n\r\n- Chất liệu : thun\r\n\r\n- Năm sản xuất : 2016\r\n\r\n- Xuất xứ : Việt nam ( công ty thái hoàng sx)\r\n\r\n- Màu sắc : xanh, đỏ , hồng\r\n\r\n- Kích thước : Freesize dành cho mẹ từ 43', '390000.00', '340000.000', 50000, 'combo-dam-doi-pendi-xinh-xan-th08560-1m4G3-GmhUQZ.jpg', '[\"combo-dam-doi-pendi-xinh-xan-th08560-1m4G3-mPSYrq.jpg\",\"combo-dam-doi-pendi-xinh-xan-th08560-1m4G3-tp7Ma5.jpg\",\"combo-dam-doi-pendi-xinh-xan-th08560-1m4G3-Xd5kQ5.jpg\"]', 2, 1, 4, 1, 1493983674),
(17, 3, 'ÁO GIA ĐÌNH AG0554', 'Thông tin về sản phẩm:\r\n\r\n         Kiểu áo : Áo thun cổ tròn tay ngắn.\r\n\r\n         Màu sắc: Nhiều màu sắc để lựa chọn.\r\n\r\n          Chất liệu: Thun cotton 4 chiều.\r\n\r\n         Size áo: Đủ size áo để lựa chọn.\r\n\r\n          Công nghệ in: Mimaki của Nhật Bản.\r\n', '500000.00', '450000.000', 50000, 'ao-gia-dinh-AG0554.jpg', '[\"ao-gia-dinh-AG0554-1.jpg\",\"ao-gia-dinh-AG0554-2.jpg\",\"ao-gia-dinh-AG0554-3.jpg\",\"ao-gia-dinh-AG0554-4.jpg\"]', 37, 1, 14, 4, 1493983674),
(16, 3, 'ÁO GIA ĐÌNH AG0560', 'Áo gia đình kẻ sọc ngang rất được ưa chuộng hiện nay, dù là ở lứa tuổi nào thì thời trang kẻ sọc cũng luôn mang đên cho người mặc một phong cách trẻ trung năng động và cá tính.</p>\r\n\r\n        Không mặc sọc ngang từ đầu đến chân là bí quyết gia đình bạn nên biết.\r\n\r\n        Chọn chất liệu mềm và phom dáng suôn rộng để che khuyết điểm.\r\n\r\n          Chọn sọc kẻ ngang vừa phải, không đụng tới sọc to.\r\n', '580000.00', '400000.000', 180000, 'ao-gia-dinh-AG0560-1.jpg', '[\"ao-gia-dinh-AG0560.jpg\",\"ao-gia-dinh-AG0560-2.jpg\",\"ao-gia-dinh-AG0560-3.jpg\",\"ao-gia-dinh-AG0560-4.jpg\"]', 7, 3, 13, 3, 1493983674),
(14, 2, 'ĐẦM ÔM BODY CỔ ĐÍNH HẠT', 'CHẤT LIỆU : THUN COTON CO GIÃN THOÁNG MÁT DỂ CHIỆU \r\n\r\nTHÍCH HỢP MỌI HOẠT ĐỘNG : CÔNG SỞ , DỰ TIỆC , DẠO PHỐ , ĐI BIỂN ....\r\n\r\nSIZE :\r\n\r\nMÀU : CAM NÂU, XÁM ĐEN ( Ô MÀU CHỌN LÀ XÁM ) XANH LAM , TRẮNG \r\n', '200000.00', '150000.000', 50000, 'dam-om-body-co-dinh-hat-1m4G3-22CEL4_simg_d0daf0_800x1200_max.jpg', '[\"dam-om-body-co-dinh-hat-1m4G3-qrWR6I_simg_d0daf0_800x1200_max.jpg\",\"dam-om-body-co-dinh-hat-1m4G3-tVjWlK_simg_d0daf0_800x1200_max.jpg\",\"dam-om-body-co-dinh-hat-1m4G3-XI1vLB_simg_d0daf0_800x1200_max.jpg\"]', 5, 2, 4, 1, 1493983674),
(15, 2, 'ĐẦM XÒE PHỐI REN CAO CẤP', 'Chất liệu ren  cho 1 bạn 1 phong cách sang chảnh thu đông năm nay ,với các màu diệu ,nồng nằng quyến rũ không thể nào không cuốn hút đươc tất cả ánh nhìn xung quanh hòa quyện vào dạng xòe cổ điển cao cấp .\r\nMàu : đen , xanh , đỏ \r\nSize : M 45 - 52 kg tùy theo chiều cao \r\nXưởng nhận may gia công tất cả các mặt hàng thời trang nam nữ \r\nVới chất liệu bắt mắt và chất lượng rất ok nắm bắt xu hướng thời trang thu đông năm nay \r\nMẫu váy xòe ren là sự lựa chọn tốt nhất cho bạn.\r\n', '350000.00', '170000.000', 180000, 'dam-xoe-phoi-ren-cao-cap-1m4G3-lsWUnT.jpg', '[\"dam-xoe-phoi-ren-cao-cap-1m4G3-AQuuDj.jpg\",\"dam-xoe-phoi-ren-cao-cap-1m4G3-FGCII2.jpg\",\"dam-xoe-phoi-ren-cao-cap-1m4G3-qxyXGj.jpg\",\"dam-xoe-phoi-ren-cao-cap-1m4G3-ztYeGq.jpg\"]', 5, 2, 4, 1, 1493983674),
(10, 2, 'ÁO THUN FORM RỘNG', '- Áo thun nữ trẻ trung có thiết kế năng động với cổ tròn, tay ngắn mang lại cho bạn sự thoải mái khi mặc.\r\n- Thiết kế form rộng cá tính cho bạn luôn cảm thấy dễ chịu khi mặc trong thời gian dài.\r\n- In họa tiết chữ đơn giản, trẻ trung tạo nét cá tính riêng cho sản phẩm.\r\n- Đường may chắc chắn, cẩn thận cho bạn tự tin hơn trong vận động.\r\n- Chất liệu: thun cotton 4 chiều co giãn tốt, thấm hút mồ hôi hiệu quả.\r\n- Size: freesize\r\n- Màu sắc: trắng, đen, xanh biển', '129000.00', '69000.000', 60000, 'ao-thun-ao-phong-nu-eiffel-ca-tinh-msat28-1m4G3-PP5C91_simg_d0daf0_800x1200_max.jpg', '[\"ao-thun-ao-phong-nu-eiffel-ca-tinh-msat28-1m4G3-LpJZdC_simg_d0daf0_800x1200_max.jpg\",\"ao-thun-ao-phong-nu-eiffel-ca-tinh-msat28-1m4G3-ZyFQ9v_simg_d0daf0_800x1200_max.jpg\"]', 8, 2, 4, 1, 1493983674),
(55, 0, 'ÁO SƠ MI NAM DÀI TAY ARISTINO ASM001', 'KIỂU DÁNG: REGULAR FIT\r\nCHI TIẾT:\r\n- Áo sơ mi dài tay phom Regular fit suông nhẹ, đứng dáng, đem đến cảm giác thoải mái cho người mặc.\r\n- Áo thiết tà lượn, có túi, màu xanh kẻ trắng nhã nhặn, lịch lãm nhưng vẫn trẻ trung, thời thượng.\r\nCHẤT LIỆU:\r\n- 50% Bamboo mang đến sự thoáng mát, thấm hút tốt.\r\n- 50% Polyspun mang đến khả năng đàn hồi tự nhiên và ít nhăn co trong suốt quá trình sử dụng.\r\nMÀU SẮC: Xanh kẻ trắng\r\nSIZE: 38 - 39 - 40 - 41 - 42 - 43', '795000.00', '715500.000', 79500, 'somi_one_01.jpg', '[]', 0, 0, 4, 1, 1638209331),
(9, 2, 'ÁO THUN NỮ ROMA', '►Chất liệu cao cấp COTTON 4 CHIỀU mềm mại\r\n►Co giãn tốt ; thoáng mát     ►Thiết kế thời trang\r\n►Kiểu dáng đa phong cách   ►Đường may tinh tế sắc sảo\r\n► Áo thun nữ được thiết kế và sản xuất bởi Trần Doanh mang vể đẹp trẻ trung năng động nhưng không kém phần duyên dáng.\r\n►Áo được thiết kế đẹp, chuẩn form, đường may sắc xảo, vải cotton dày, mịn, thấm hút mồ hôi tạo sự thoải mái khi mặc!\r\n►Thích hợp cho sự kết hợp vứi quần jean, sọt,legging!', '180000.00', '80000.000', 100000, 'ao-thun-ao-phong-nu-hoa-tiet-chu-roma.jpg', '[\"ao-thun-ao-phong-nu-hoa-tiet-chu-roma-ca-tin.jpg\",\"ao-thun-ao-phong-nu-hoa-tiet-chu-roma-ca-tinh.jpg\"]', 2, 1, 4, 1, 1493983674),
(7, 2, 'ĐẦM REN TAY DÀI TIỂU THƯ', 'Đầm ren tay dài tiểu thư duyên dáng nữ tính trị giá 450.000 VNĐ nay chỉ còn 350.000 VNĐ\r\n\r\nCác thông tin như sau:\r\n\r\n+ Mẫu mã: như hình;\r\n\r\n+ Xuất xứ: Việt Nam\r\n\r\n+ Màu sắc: Hồng, xanh, trắng, tím\r\n\r\n+ Kiểu dáng: tay lỡ, vạt ngang, cổ tròn kèm dây chuyền phụ kiện;\r\n\r\n+ Size: S, M, L, XL', '450000.00', '350000.000', 100000, 'Dam_ren_den_tay_dai_tieu_thu_(3).jpg', '[\"Dam_ren_den_tay_dai_tieu_thu_(2).jpg\",\"Dam_ren_den_tay_dai_tieu_thu_(13).jpg\",\"Dam_ren_tieu_thu_tay_dai_(1).jpg\"]', 25, 6, 13, 3, 1493983674),
(13, 2, 'ĐẦM REN THÁI FORM DÀI', 'Chất liệu: Ren Thái cao cấp, lớp lót trong dày dặn\r\n\r\nKiểu dáng Đầm không tay, cổ tròn, Chân váy xòe, dài ngang bắp chân. Kiểu dáng mềm mại thướt tha đầy nữ tính\r\n\r\nMã sản phẩm: DR 26\r\n', '200000.00', '100000.000', 10000, 'dam-ren-thai-form-dai-1m4G3-9f2a11.jpg', '[\"dam-ren-thai-form-dai-1m4G3-38d74e.jpg\",\"dam-ren-thai-form-dai-1m4G3-918972.jpg\",\"dam-ren-thai-form-dai-1m4G3-d5e05d.jpg\"]', 6, 2, 4, 1, 1493983674),
(6, 2, 'ÁO KIỂU CÔNG SỞ', 'Áo kiểu mang đến vẻ đẹp nữ tính, dịu dàng cho nàng!\r\n\r\nVới chất vải vô cùng mềm mại và nhẹ nhàng, chiếc áo kiểu làm từ chất liệu voan này luôn phát huy và tô điểm được vẻ đẹp nữ tính, dịu dàng của bạn gái. Nhất là với những kiểu dáng cổ bèo cách điệu hay họa tiết xinh xắn lại càng giúp nàng khoe thêm được sự điệu đà và ấn tượng của mình. Bởi thế, chiếc áo này vô cùng phù hợp với những cô nàng có phong cách thời trang nữ tính, nhẹ nhàng.', '300000.00', '200000.000', 100000, 'ao-kieu-cong-so-a0122-1m4G3-ZebjMN_simg_d0daf0_800x1200_max.png', '[\"ao-kieu-cong-so-a0122-1m4G3-o0hhot_simg_d0daf0_800x1200_max.png\",\"ao-kieu-cong-so-a0122-1m4G3-qXBUW2_simg_d0daf0_800x1200_max.png\",\"ao-kieu-cong-so-a0122-1m4G3-vS6ei3_simg_d0daf0_800x1200_max.png\"]', 2, 1, 4, 1, 1493983674),
(12, 2, 'ĐẦM MAXI PHỐI REN CAO CẤP', 'Chất liệu: Chiffon phối ren cao cấp\r\nMàu sắc: Đen, hồng\r\nKích thước: S,M,L,XL\r\nXuất Xứ : Việt Nam \r\n\r\n size S: Chiều dài đầm: 130cm, Ngực 78-80cm, Eo 64-68cm, Mông 84-86cm\r\n\r\n size M: Chiều dài đầm: 130cm, Ngực 80-84cm, Eo 68-72cm, Mông 86-90cm\r\nsize L: Chiều dài đầm: 130cm, Ngực 84-88cm, Eo 72-76cm, Mông 90-96cm\r\n size XL: Chiều dài đầm: 130cm, Ngực 88-92cm, Eo 76-78cm, Mông 96-100cm\r\n', '720000.00', '360000.000', 360000, 'dam-maxi-phoi-ren-cao-cap-1m4G3-QXVTv3_simg_d0daf0_800x1200_max.jpg', '[\"dam-maxi-phoi-ren-cao-cap-1m4G3-sh6ofY_simg_d0daf0_800x1200_max.jpg\",\"dam-maxi-phoi-ren-cao-cap-1m4G3-sUX4Gv_simg_d0daf0_800x1200_max.jpg\",\"dam-maxi-phoi-ren-cao-cap-1m4G3-VEbARk_simg_d0daf0_800x1200_max.jpg\"]', 28, 4, 9, 2, 0),
(56, 1, 'ÁO SƠ MI NAM DÀI TAY ARISTINO ASM001', 'KIỂU DÁNG: REGULAR FIT\r\nCHI TIẾT:\r\n- Áo sơ mi dài tay phom Regular fit suông nhẹ, đứng dáng, đem đến cảm giác thoải mái cho người mặc.\r\n- Áo thiết tà lượn, có túi, màu xanh kẻ trắng nhã nhặn, lịch lãm nhưng vẫn trẻ trung, thời thượng.\r\nCHẤT LIỆU:\r\n- 50% Bamboo mang đến sự thoáng mát, thấm hút tốt.\r\n- 50% Polyspun mang đến khả năng đàn hồi tự nhiên và ít nhăn co trong suốt quá trình sử dụng.\r\nMÀU SẮC: Xanh kẻ trắng\r\nSIZE: 38 - 39 - 40 - 41 - 42 - 43', '795000.00', '715500.000', 79500, 'somi_one_011.jpg', '[]', 0, 0, 4, 1, 1638209491),
(57, 1, 'ÁO SƠ MI DÀI TAY NAM ARISTINO ASM002', 'KIỂU DÁNG: SLIM FIT\r\nCHI TIẾT:\r\n- Áo sơ mi dài tay phom Slim fit\r\n- Áo thiết kế tà lượn, không túi. Màu đen trung tính, dễ kết hợp trang phục. Họa tiết kẻ caro xám tạo điểm nhấn nổi bật trên áo\r\nCHẤT LIỆU:\r\n- 49% Modal giúp áo mềm mại và thấm hút tốt.\r\n- 49% Polyester giúp quần bền màu, sắc nét, mặt vải trơn trượt, mỏng nhẹ.\r\n- 2% Cotton giúp áo mềm mại, xốp nhẹ và thoáng khí.\r\nMÀU SẮC: Đen kẻ caro xám\r\nSIZE: 38 - 39 - 40 - 41 - 42 - 43', '795000.00', '715500.000', 79500, 'somi_two_01.jpg', '[]', 0, 0, 4, 1, 1638209597),
(3, 2, 'ẢO KIỂU HÀN QUỐC V0040', 'ẢO KIỂU HÀN QUỐC V0040  tay lỡ là gu chủ yếu cho những ngày thu. Nếu như hè bạn có thể táo bạo diện một chiếc sơ mi không tay hay kiểu cổ phóng khoáng cho thời trang công sở thì sang thu sẽ kín đáo hơn nhiều với kiểu sơ mi tay lỡ hoặc dáng dài tay đều phù hợp.\r\n\r\nNhững mẫu sơ mi thiết kế tay lỡ vẫn sử dụng gam đơn hoặc họa tiết nếu muốn mix phù hợp cùng quần tây, jean hay chân váy ăn ý.\r\n\r\nẢO KIỂU HÀN QUỐC V0040 với các thông tin như sau:\r\n\r\n+ Mẫu mã: như hình;\r\n\r\n+ Xuất xứ: Việt Nam\r\n\r\n+ Màu sắc: Hồng, xanh, trắng, tím\r\n\r\n+ Kiểu dáng: tay lỡ, vạt ngang, cổ tròn kèm dây chuyền phụ kiện;\r\n\r\n+ Size: S, M, L, XL', '300000.00', '150000.000', 150000, 'ao-kieu-han-quoc-v0040-1m4G3-8352b3_simg_d0daf0_800x1200_max.jpg', '[\"ao-kieu-han-quoc-v0040-1m4G3-7118e0_simg_d0daf0_800x1200_max.jpg\",\"ao-kieu-han-quoc-v0040-1m4G3-131527_simg_d0daf0_800x1200_max.jpg\"]', 47, 4, 11, 3, 1493983674),
(54, 1, 'ÁO KHOÁC NAM ARISTINO AK003', 'KIỂU DÁNG: REGULAR FIT\r\nCHI TIẾT:\r\n- Áo khoác 2 lớp phom Regular Fit có độ suông vừa đủ nhưng đồng thời vẫn vừa vặn với số đo hình thể nam giới Việt.\r\n- Thiết kế dáng bomber, họa tiết lượn sóng trắng trên nền xanh tím than. Áo thiết kế cổ bóng chày đầy khỏe khoắn, phần cổ và tay áo dệt bo rib chắc chắn.\r\n- Áo sử dụng khóa kim loại bạc cho cả phần thân và túi áo để đảm bảo sự bền chắc và không gỉ theo thời gian, trên tay áo được may túi ốp trang trí.\r\nCHẤT LIỆU:\r\n- 100% Polyester đem tới cho áo sự mềm nhẹ, mặt vải trơn mượt, màu sắc sắc nét và khả năng giữ ấm cơ thể tuyệt vời.\r\nMÀU SẮC: Xanh biển nhạt 8in\r\nSIZE: S – M – L – XL', '1550000.00', '775000.000', 775000, 'aokhoac_three_01.jpg', '[]', 0, 0, 4, 1, 1638209026),
(1, 2, 'ÁO VIỀN CỔ HOA', 'Áo Sơ Mi Nữ Viền Cổ Hoa 3D Thiết Kế Cổ Tròn Viền Sọc Đen, Kết Nút Cổ Sau Lưng, Tay Xòe Duyên Dáng, Kết Hoa 3D Thêm Phần Nữ Tính Cho Phái Đẹp, Chất Liệu Voan Mềm Mại, Thoáng Mát\r\n\r\nChất Liệu: Voan Mềm Mại, Thoáng Mát\r\n\r\nMàu Sắc: Tím, Hồng\r\n\r\nKiểu Dáng: Thiết Kế Cổ Tròn Viền Sọc Đen, Kết Nút Cổ Sau Lưng, Tay Xòe Duyên Dáng, Kết Hoa 3D Thêm Phần Nữ Tính Cho Phái Đẹp\r\n\r\nKích Thước: Size S - Dài Áo: 60, Rộng Vai: 28 - 32, Vòng Ngực: 74 - 84 ( Phù Hợp Với Bạn Nữ Dưới 50kg) \r\n\r\n                     Size M - Dài Áo: 62, Rộng Vai: 29 - 33, Vòng Ngực: 76 - 86 ( Phù Hợp Với Bạn Nữ Dưới 55kg)\r\n\r\n                      Size L - Dài Áo: 63, Rộng Vai: 31 - 35, Vòng Ngực: 84 - 94( Phù Hợp Với Bạn Nữ Dưới 60kg)', '179000.00', '159000.000', 20000, 'ao-so-mi-nu-vien-co-hoa-31.jpg', '[\"ao-so-mi-nu-vien-co-hoa-3d1.jpg\",\"ao-so-mi-nu-vien-co-hoa-3dl1.jpg\",\"ao-so-mi-nu-vien-co-hoa-3dla1.jpg\"]', 31, 1, 14, 3, 1493983674),
(161, 1, 'Áo Giữ Nhiệt Nam Cổ Lọ', 'Chất liệu vải 95% viscose+ 5% spandex\r\nVải thấm hút tốt\r\nMềm mại, thoáng mái mang đến cảm giác thoải mái\r\nPhom ôm sát gọn gàng mà vẫn thoải mái co kéo, hoạt động\r\nÁo giữ nhiệt nam kiểu dáng cơ bản,ôm vừa cơ thể,cổ lọ giúp giữ ấm tốt,chất liệu thoải mái, thoáng không gây kích ứng hay khó chịu\r\nDễ phối đồ có thể mặc trong áo vest, măng tô hay áo khoác kết hợp cùng quần jean,quần âu hay quần nỉ \r\n', '29900.00', '0.000', 0, 'apm4069-tna-qsm4019-bee-21.jpg', '[]', 0, 0, 4, 1, 1640007765),
(160, 1, 'Áo Sơ Mi Nam Công Sở Túi Bổ', 'Chất liệu vải 100% Cotton\r\nÁo sơ mi flannel đang được rất nhiều chàng trai ưa thích lựa chọn\r\nBền bỉ thêm phần mềm mại, ấm áp, thoải mái mà áo sơ mi tạo nên.\r\nVải Flannel cho bề mặt mềm mại, được dệt mỏng\r\nThay thế những chiếc áp sơ mi mỏng mùa xuân hè của bạn.\r\nMang đến cảm giác ấm cúng, rất mùa thu, thu hút mọi ánh nhìn, tạo nên vẻ ngoài nam tính, bụi bặm\r\n', '321100.00', '0.000', 0, 'apm3791-xam-11.jpg', '[]', 0, 0, 4, 1, 1640007732),
(159, 1, 'Áo Sơ Mi Nam Kẻ Sọc Có Túi Trẻ Trung', 'Chất liệu 70% Polyester, 10% Rayon, 5% spandex\r\nChất liệu mềm mại, ít nhăn, co dãn 4 chiều\r\nThoáng mát mang đến cảm giác dễ chịu, thoải mái cho bạn\r\nHọa tiết trẻ trung, năng động\r\nKiểu dáng cơ bản trên nền kẻ sọc đen, nẹp áo khỏe khoắn, nổi bật là hàng cúc màu đen \r\n', '328300.00', '0.000', 0, 'apm4355-vag-51.jpg', '[]', 0, 0, 4, 1, 1640007697),
(107, 1, 'ÁO GIÓ NAM THỂ THAO CHỐNG NGẤM NƯỚC', 'Chất liệu: Chipu Cao Cấp với thành phần: 100% polyester\r\nThiết kế đặc biệt giúp chất liệu có độ mềm mại và tạo ra khả năng chống thấm nước vào bên trong\r\ncản gió vô cùng hiệu quả trong những ngày trời trở lạnh.\r\nKhả năng chống bụi bẩn, chống nắng hiệu quả.', '399000.00', '0.000', 0, 'akm4001-dgh-qjm4005-xba-7.jpg', '[]', 0, 0, 4, 1, 1638296668),
(157, 1, 'Áo Polo Nam Kẻ Sọc Ngang MELANGE', 'Chất liệu: 65% RAYON+ 30% POLYESTER+ 5% SPANDEX\r\nChẩt vải mềm mịn với làn da, thông thoáng thấm hút mồ hôi tốt\r\nPolo kẻ với phom dáng polo tiêu chuẩn, kiểu dáng basic\r\nThông dụng trong mọi hoàn cảnh, đi làm, đi chơi bởi sự tiện dụng, thoải mái\r\n', '249000.00', '0.000', 0, 'apm4107-den-21.jpg', '[]', 0, 0, 4, 1, 1640007616),
(158, 1, 'Áo Len Nam Cổ Lọ Tay Dài Basic', 'Chất liệu 100% Viscose\r\nThoáng khí và thấm hút cực tốt\r\nMềm mại, không tích điện, không gây bám dính, giúp người mặc tránh được cảm giác khó chịu.\r\nHạn chế được sự phát triển của nấm mốc, vi khuẩn nhờ khả năng thoáng khí hiệu quả\r\nCó khả năng phân hủy sinh học\r\nÁo len nam kiểu dáng suông cơ bản,cổ lọ hàn quốc\r\nTrời lạnh có thể kết hợp cùng các loại áo khoác cũng đều rất basic,lịch sự và thoải mái\r\n', '399000.00', '0.000', 0, 'phm4001-den-31.jpg', '[]', 0, 0, 4, 1, 1640007662),
(154, 1, 'Áo Khoác Phao Nam Siêu Nhẹ Có Mũ', 'Màu sắc sản phẩm đa dạng, thiết kế form dáng trẻ trung\r\nCó thiết kế túi đựng nhỏ gọn, dễ dàng mang theo sản phẩm\r\nSiêu nhẹ, có tác dụng giữ ấm cho cơ thể\r\nChống thấm nước, tránh mưa nhẹ, chống tĩnh điện\r\n', '499000.00', '0.000', 0, 'akm4687-tit-51.jpg', '[]', 0, 0, 4, 1, 1640007501),
(153, 1, 'Áo Phao Nam Có Mũ Siêu Nhẹ Hai Mặt', 'Chất liệu 100% polyester\r\nMẫu áo phao siêu nhẹ có thể sử dụng được 2 mặt sản phẩm\r\nMặt ngoài là lớp vải 380T loại vải thông dụng nhất trong sản phẩm áo phao giữ ấm mùa đông\r\nMặt trong là lớp vải 100% polyester với bề măt vải mịn, chắc, bền màu và kháng nước tốt\r\nChỉ với 1 sản phẩm ,khách hàng có thể sử dụng được cả mặt trong và ngoài với 2 thiết kế riêng biệt\r\n', '1259000.00', '0.000', 0, 'akm4027-nau-42.jpg', '[]', 0, 0, 4, 1, 1640007452),
(152, 1, 'Áo Phao Nam Có Mũ Siêu Nhẹ Hai Mặt', 'Chất liệu 100% polyester\r\nMẫu áo phao siêu nhẹ có thể sử dụng được 2 mặt sản phẩm\r\nMặt ngoài là lớp vải 380T loại vải thông dụng nhất trong sản phẩm áo phao giữ ấm mùa đông\r\nMặt trong là lớp vải 100% polyester với bề măt vải mịn, chắc, bền màu và kháng nước tốt\r\nChỉ với 1 sản phẩm ,khách hàng có thể sử dụng được cả mặt trong và ngoài với 2 thiết kế riêng biệt\r\n', '1259000.00', '0.000', 0, 'akm4027-nau-41.jpg', '[]', 0, 0, 4, 1, 1640007451),
(149, 1, 'Áo Gió Nam Thể Thao Chống Ngấm Nước', 'Chất liệu: Chipu Cao Cấp với thành phần: 100% polyester\r\nThiết kế đặc biệt giúp chất liệu có độ mềm mại và tạo ra khả năng chống thấm nước vào bên trong\r\ncản gió vô cùng hiệu quả trong những ngày trời trở lạnh.\r\nKhả năng chống bụi bẩn, chống nắng hiệu quả\r\n', '399000.00', '0.000', 0, 'akm3017-dod-qjm4005-xba-5.jpg', '[]', 0, 0, 4, 1, 1640007144),
(150, 1, 'Áo Khoác Nam 2 Lớp Phối Màu', 'Áo khoác 2 lớp giành cho nam. áo được pha phối giữa 2 màu do YODY phát triển\r\nBề mặt cản gió, giữ ấm cho cơ thể\r\nBên ngoài áo được thiết kế 2 đường lé phối chạy song song từ chân cổ tới tay áo\r\nCổ tay được thiết kế cúc bấm giúp sản phẩm da năng và trẻ trung\r\nTúi áo chéo giúp khách hàng dễ đút tay vào bên trong\r\nPhần thân áo được thiết kế chun chạy quanh thân\r\nDễ phối với nhiều loại quần áo khác nhau\r\n', '499000.00', '0.000', 0, 'akm4001-dgh-qjm4005-xba-71.jpg', '[]', 0, 0, 4, 1, 1640007290),
(151, 1, 'Áo Khoác Phao Nam Có Mũ Siêu Nhẹ', 'Chất liệu vải POLYESTER CAO CẤP với thành phần: lớp ngoài 100% Nylon x lớp giữa 100% Polyester x lớp lót 100% Nylon\r\nChất liệu siêu nhẹ và có độ mềm mịn vượt trội\r\nChống thấm nước tốt, yên tâm khi trời mưa nhẹ lất phất\r\nChất liệu cao cấp chống tĩnh điện giúp bảo vệ sức khỏe người mặc\r\nChất vải ít nhăn, bền màu\r\n', '1259000.00', '0.000', 0, 'phm4003-xdo-qjm3051-den-121.jpg', '[]', 0, 0, 4, 1, 1640007342),
(128, 2, 'VÁY SUÔNG NỮ, ĐẦM SUÔNG 2', 'Váy suông nữ, đầm suông 2 dây loang dáng xòe kiểu mới lạ mắt. Đường may tỉ mỉ, xếp ly lên form chuẩn mẫu. Chất liệu đũi lụa đảm bảo các chị em mặc muà hè này mát lạnh cực thích. Kiểu dáng maxi 2 dây thiết kế khoá lưng tiện lợi. Phần chân váy xếp ly tạo nên cảm giác eo gọn hơn cho người mặc.', '315000.00', '265000.000', 50000, 'dam-ren-thai-form-dai-1m4G3-d5e05d1.jpg', '[]', 0, 0, 4, 1, 1638298490),
(164, 1, 'Áo Sơ Mi Nam Kẻ Caro Vải Cotton Năng Động', 'Chất liệu cotton tạo nên vải flannel\r\nVải Flannel cho bề mặt mềm mại, được dệt mỏng, “chải” mềm và gỡ rối, tạo ra sự dẻo dai của sợi\r\nChiếc sơ mi flannel vì sự bền bỉ thêm phần mềm mại, ấm áp, thoải mái mà nó tạo nên.\r\nChàng trai nào lại muốn bỏ lỡ một chiếc áo sơ mi flannel kẻ trẻ trung, năng động \r\n', '249000.00', '0.000', 0, 'apm3757-tbd-72.jpg', '[]', 0, 0, 4, 1, 1640007863),
(165, 1, 'Áo Sơ Mi Nam Caro Có Túi Ngực', 'Chất liệu: 100% Cotton \r\nVải Flannel cho bề mặt mềm mại, được dệt mỏng\r\nSet đồ của bạn sẽ luôn toát ra sự trẻ trung, năng động, thân thiện.\r\nĐược các chàng trai ưa thích lựa chọn và trở thành một trong những item hot nhất.\r\nSự bền bỉ thêm phần mềm mại, ấm áp, thoải mái mà nó tạo nên.\r\n', '399000.00', '0.000', 0, 'apm4205-cf2-31.jpg', '[]', 0, 0, 4, 1, 1640007893),
(166, 1, 'Áo Polo Nam Cafe Phối Cổ Sơ Mi Kẻ', 'Chất liệu vải 50% cafe+ 50% recycled PET\r\nSợi tự nhiên ngắn, có liên kết liên minh với một số sợi nhân tạo, để tạo nên sự bền chắc\r\nChất liệu cafe kiểm soát mùi, nhanh khô, ngăn ngừa tia UV tự nhiên\r\nChất liệu xanh thân thiện với môi trường\r\nÁo polo kiểu dáng cơ bản dễ mặc phù hợp với nhiều đối tượng khách hàng\r\n\r\n', '249000.00', '0.000', 0, 'apm4233-xmt-21.jpg', '[]', 0, 0, 4, 1, 1640007927),
(167, 1, 'Áo Polo Nam Cafe Bo Trơn', 'Chất liệu: sợi Café có thành phần 50% sợi cafe và 50% sợi PET\r\nSản phẩm nằm trong BST Everyday Wear\r\nKết cấu sợi vải chặt chẽ giúp vải không bị bai dão và nhăn nhàu\r\nKhả năng loại bỏ mùi cơ thể, mùi mồ hôi, mùi thuốc lá rất hiệu quả.\r\nCổ áo polo được làm ôm nhẹ mềm mại và đặc biệt rất dễ vào phom tôn dáng cho người mặc\r\n', '249000.00', '0.000', 0, 'apm4349-tra-qjm3055-xh2-3-of-91.jpg', '[]', 0, 0, 4, 1, 1640007958),
(168, 1, 'Áo Polo Nam Cafe Bo Trơn', 'Chất liệu: sợi Café có thành phần 50% sợi cafe và 50% sợi PET\r\nSản phẩm nằm trong BST Everyday Wear\r\nKết cấu sợi vải chặt chẽ giúp vải không bị bai dão và nhăn nhàu\r\nKhả năng loại bỏ mùi cơ thể, mùi mồ hôi, mùi thuốc lá rất hiệu quả.\r\nCổ áo polo được làm ôm nhẹ mềm mại và đặc biệt rất dễ vào phom tôn dáng cho người mặc\r\n', '249000.00', '0.000', 0, 'apm4349-tra-qjm3055-xh2-3-of-92.jpg', '[]', 0, 0, 4, 1, 1640007958);
INSERT INTO `product` (`id`, `catalog_id`, `name`, `content`, `price`, `price_new`, `discount`, `image_link`, `image_list`, `view`, `buyed`, `rate_total`, `rate_count`, `created`) VALUES
(169, 1, 'Áo Polo Nam Coolmax Ngắn Tay Phối Bo', 'Chất liệu vải chống tĩnh điện, chống tia cực tím\r\nĐặc tính kháng khuẩn, khử mùi, thấm hút tốt và kiểm soát độ ẩm\r\nÁo polo phối màu dễ phối với nhiều trang phục khác nhau.\r\nÁo polo kết hợp với quần âu, quần jean, quần short ngắn thoải mái dễ chịu\r\n', '249000.00', '0.000', 0, 'apm3959-xag-11.jpg', '[]', 0, 0, 4, 1, 1640007997),
(170, 1, 'Áo Polo Nam Vải Hàu Phối Vai', 'Chất liệu: Pique mắt chim với thành phần 57% cotton+ 38% polyester+ 5% spandex\r\nThoáng mát,mềm mại, mịn màng\r\nThấm hút mồ hôi tốt\r\nCo giãn đàn hồi tốt, độ bền cao\r\n', '249000.00', '0.000', 0, 'apm4225-ddoqjm3077-xde-31.jpg', '[]', 0, 1, 4, 1, 1640008033),
(171, 1, 'Áo Polo Nam Cafe Bo Phối Cổ', 'Chất liệu: sợi Cafe thân thiện với môi trường\r\nThoáng khí, khử mùi hiệu quả\r\nCó khả năng ngăn ngừa tia UV\r\nMềm mại, an toàn cho da người sử dụng\r\nÁo có form sáng suông, phối màu cổ và bo tay khỏe khoắn, nam tính\r\nCó thể phối đồ cùng quần short, quần âu, quần jeans đều đẹp\r\n', '249000.00', '0.000', 0, 'apm4069-tna-qsm4019-bee-22.jpg', '[]', 0, 0, 4, 1, 1640008061),
(172, 1, 'Áo Sơ Mi Nam Tay Dài Cafe Melange', 'Chất liệu: Sợi cafe bao gồm 50% cafe và 50% recycle PET\r\nSợi cafe là 1 sợi tự nhiên ngắn, bền chắc.\r\nCông nghệ S.Cafe còn được nghiên cứu quy tình sản xuất tiết kiệm năng lượng, sử dụng những giá trị bền vững và thân thiện với mội trường.\r\nVải Cafe siêu nhẹ, siêu mát, kiểm soát mùi cơ thể và chống tia UV\r\n', '549000.00', '0.000', 0, 'apm3959-xag-12.jpg', '[]', 0, 0, 4, 1, 1640008104),
(173, 1, 'Áo Sơ Mi Nam Tay Dài Họa Tiết Slimfit', 'Chất liệu vải oxford là loại vải dệt được pha trộn giữa xen kẽ với sợi bông và sợi pha polyester và bông.\r\nVải có bề mặt mềm mịn, có độ thẩm mỹ cao\r\nChất liệu vải bền màu, khả năng thấm hút tốt, không bai dão, phom chuẩn\r\nCảm giác thông thoáng, càng giặt càng mềm\r\n', '399000.00', '0.000', 0, 'apm4205-cf2-32.jpg', '[]', 0, 0, 4, 1, 1640008134),
(174, 2, 'ĐẦM DÂY ĐẮP CHÉO TÀ', 'Đầm dây đắp chéo tà\r\n- Tên Sản Phẩm: Đầm dây đắp chéo tà\r\n- Giá Bán: 480,000vnđ\r\n- Màu Sắc: BE\r\n- Số Đo Ngực: 84CM\r\n- Số Đo Eo: 66CM\r\n- Số Đo Dài Dây: 53CM\r\n- Số Đo Hạ V: 12CM\r\n- Chiều Dài Đầm: 90CM\r\n- Thông Số Size S\r\n- Số Size XS, S, M, L\r\n- Chất Liệu Vải: THUN VÂN GỖ\r\n- Có 1 Lớp\r\n- Không Có Túi\r\n*ĐẦM 2 DÂY FORM BÚT CHÌ, CỔ V, PHẦN NÁCH 2 BÊN THIẾT KẾ CÁCH ĐIỆU TẠO KIỂU, ĐẦM RÃ EO, PHẦN TÙNG VÁY ĐẮP CHÉO TÀ TỪ BÊN PHẢI QUA BÊN TRÁI, DÂY KÉO PHÍA SAU.', '480000.00', '0.000', 0, 'vayday_one_011.jpg', '[]', 0, 0, 4, 1, 1640008464),
(175, 2, 'ĐẦM BODY CỔ V ĐẮP', 'Đầm body cổ V đắp\r\n- Tên Sản Phẩm: Đầm body cổ V đắp \r\n- Giá Bán: 495,000vnđ\r\n- Màu Sắc: Đen, Hồng\r\n- Số Đo Ngực: 80CM\r\n- Số Đo Eo: 61CM\r\n- Số Đo Mông: 88CM\r\n- Số Đo Vai: 33CM\r\n- Số Đo Hạ V: 16.5CM\r\n- Số Đo Dài Tay: 13CM\r\n- Số Đo Cửa Tay: 25CM\r\n- Số Đo Dài Đầm: 90CM\r\n- Thông Số Size: XS\r\n- Chất Liệu Vải:\r\n- LỚP CHÍNH: COTTON MISA\r\n- LỚP LÓT: LỤA\r\n- Có 2 Lớp\r\n- Không Có Túi', '495000.00', '0.000', 0, 'dambody_one_011.jpg', '[]', 0, 0, 4, 1, 1640008508),
(178, 2, 'ĐẦM SƠ MI THẮT EO', 'Đầm sơ mi thắt eo\r\n- Tên Sản Phẩm: Đầm sơ mi thắt eo\r\n- Giá Bán: 495,000vnđ\r\n- Màu Sắc: XANH\r\n- Số Đo Ngực: 90CM\r\n- Số Đo Dài Tay: 52CM\r\n- Số Đo Cửa Tay: 18CM\r\n- Số Đo Vai: 36CM\r\n- Chiều Dài Đầm: 101CM\r\n- Thông Số Size: XS\r\n- Số Size: XS, S, M, L, XL\r\n- Chất Liệu Vải: COTTON SỌC\r\n*ĐẦM SƠ MI FORM SUÔNG, NÚT LÀ NÚT CHẾT KHÔNG THÁO MỞ ĐƯỢC. TAY DÀI PHỐI MĂNG SẾT, BẢN MĂNG SẾT KHOẢNG 9.5CM CÓ NÚT NHỰA, XẾP LY NHÚN Ở CỬA TAY, THÂN SAU CÓ RÃ ĐÔ, XẾP LY Ở GIỮA ĐÔ THÂN SAU, ĐẦM KÈM DÂY ĐAI THẮT EO CÓ THỂ THÁO RỜI, ĐẦM KHÔNG DÂY KÉO.', '475000.00', '0.000', 0, 'somithateo_one_021.jpg', '[]', 0, 0, 4, 1, 1640008627),
(177, 2, 'ĐẦM REN TAY ĐÍNH NƠ', 'Đầm ren tay đính nơ\r\n- Tên Sản Phẩm: Đầm ren tay đính nơ \r\n- Giá Bán: 590,000vnđ\r\n- Màu Sắc: TRẮNG, ĐEN\r\n- Số Đo Ngực: 88CM\r\n- Số Đo Eo: 68CM\r\n- Số Đo Vai: 33CM\r\n- Số Đo Dài Tay: 34CM\r\n- Số Đo Cửa Tay: 26CM\r\n- Chiều Dài Đầm: 102CM\r\n- Thông Số Size: S\r\n- Số Size XS-S-M-L-XL\r\n- Chất Liệu Vải: REN\r\n- Có 2 Lớp\r\n- Không Có Túi\r\n*ĐẦM FORM A XÒE CƠ BẢN, CỔ TRÒN, TAY LỞ, CỬA TAY CÓ ĐÍNH DÂY NƠ TẠO KIỂU, ĐẦM RÃ CÚP Ở NGỰC, RÃ EO, DÂY KÉO PHÍA SAU.', '590000.00', '0.000', 0, 'damren_one_011.jpg', '[]', 0, 0, 4, 1, 1640008561),
(179, 2, 'Áo Jacket thể thao nữ Livan Empower', '*Chất liệu: 95% Polyamide & 5% Spandex co giãn\r\n*Đặc điểm:\r\n- Chất liệu cao cấp, không thô ráp, mềm mại, thoải mái, co giãn, hỗ trợ tối đa các hoạt động thể chất \r\n- 2 lớp dày dặn nhưng thoáng khí, nhẹ nhàng: một lớp vải gió cao cấp, một lớp lưới\r\n- Mặc được hai kiểu bo và suông với dây rút điều chỉnh độ rộng\r\n- Khóa được thiết kế riêng bởi SBS-nhà cung cấp khóa hàng đầu thế giới, có viền che thanh lịch,  chống trượt khóa\r\n- 2 túi có khoá 2 bên tiện dụng, an toàn\r\n- Tay áo được bo viền gọn gàng để cản gió\r\n - Mũ áo có thể điều chỉnh độ rộng, giữ ấm và tiện lợi \r\n - Hình in công nghệ cao tạo thêm nét khỏe khoắn, năng động', '867000.00', '0.000', 0, 'aothethao_one_011.jpg', '[]', 0, 0, 4, 1, 1640008694),
(180, 2, 'Quần Jogger nữ phối viền', 'Quần jogger nữ phối viền có thiết kế đa công năng phù hợp mặc đi tập, đi chơi, đi làm trong thời tiết lạnh. Phần được cách điệu với chi tiết kẻ sọc dọc chân phóng khoáng, trẻ trung, năng động.\r\n* Chất liệu:\r\nPolyester & Spandex\r\n* Điểm nổi bật:\r\n- Chất vải dày dặn, giữ nhiệt tốt\r\n- Thiết kế đa công năng phù hợp mặc đi tập, đi chơi, đi làm trong thời tiết lạnh\r\n- Thiết kế kẻ sọc dọc chân phóng khoáng, trẻ trung, năng động', '595000.00', '0.000', 0, 'quanjogger_one_021.jpg', '[]', 0, 0, 4, 1, 1640008797),
(181, 2, 'CHÂN VÁY RÚT DÂY', 'Chân váy rút dây\r\n- Tên Sản Phẩm: Chân váy rút dây\r\n- Giá Bán: 295,000vnđ\r\n- Màu Sắc: Đen\r\n- Số Đo Eo: 66CM\r\n- Số Đo Mông: 82CM\r\n- Chiều Dài Chân Váy: 44CM\r\n- Thông Số Size: S\r\n- Chất Liệu Vải: TUYẾT HÀN\r\n- Có Quần Lớp Trong\r\n- Không Có Túi\r\n*CHÂN VÁY FORM ÔM, BẢN LƯNG KHOẢNG 4CM, BÊN TRÁI CÓ RÚT DÂY, PHẦN RÚT DÂY CÓ THỂ ĐIỀU CHỈNH DÀI NGẮN TÙY THEO Ý KHÁCH DÂY KÉO PHÍA SAU', '295000.00', '0.000', 0, 'chanvay_rutday_one_021.jpg', '[]', 0, 0, 4, 1, 1640008844),
(182, 2, 'CHÂN VÁY XÒE PHỐI NÚT', 'Chân váy xòe phối nút\r\n- Tên Sản Phẩm: Chân váy xòe phối nút \r\n- Giá Bán: 365,000vnđ\r\n- Màu Sắc: Hồng\r\n- Số Đo Eo: 65\r\n- Chiều Dài Chân Váy: 67\r\n- Thông Số Size: S\r\n- Chất Liệu Vải:\r\nLỚP CHÍNH: COTTON HẠT\r\nLỚP LÓT: LÓT LỤA\r\n- Có 2 Lớp\r\n- Không Có Túi\r\n*CHÂN VÁY FORM XÒE, BẢN LƯNG KHOẢNG 5.5CM, PHẦN EO Ở GIỮA TRƯỚC CÓ KHOÉT TẠO KIỂU, GIỮA CHÂN VÁY CÓ NÚT BỌC TẠO ĐIỂM NHẤN, CHÂN VÁY XẾP LY NHÚN Ở PHẦN LƯNG TẠO ĐỘ XÒE, DÂY KÉO PHÍA SAU', '365000.00', '0.000', 0, 'chanvay_rutday_one_011.jpg', '[]', 0, 0, 4, 1, 1640008878),
(183, 2, 'CHÂN VÁY XẾP LY', 'Chân váy xếp ly\r\n- Tên Sản Phẩm: Chân váy xếp ly \r\n- Giá Bán: 285,000vnđ\r\n- Màu Sắc: KEM, ĐEN\r\n- Số Đo Eo: 67CM\r\n- Chiều Dài Chân Váy: 39CM\r\n- Thông Số Size S\r\n- Chất Liệu Vải: KAKI\r\n- Số Size XS-S-M-L-XL\r\n- Có Quần Lớp Trong\r\n- Không Có Túi\r\n*CHÂN VÁY BASIC, XẾP LY TO TẠO ĐỘ XÒE, BẢN LƯNG KHOẢNG 3.5CM, DÂY KÉO PHÍA SAU.', '285000.00', '0.000', 0, 'chanvay_xeply_one_021.jpg', '[]', 0, 0, 4, 1, 1640008914),
(184, 2, 'VÁY BÚT CHÌ 1 NÚT', 'Váy bút chì 1 nút\r\n- Tên Sản Phẩm: Váy bút chì 1 nút\r\n- Giá Bán: 275,000vnđ\r\n- Số Đo Eo: 62CM\r\n- Số Đo Mông: 86CM\r\n- Số Đo Xẻ Sau: 19CM\r\n- Chiều Dài Chân Váy: 59CM\r\n- Thông Số Size: XS\r\n- Chất Liệu Vải: THUN 4 Chiều\r\n- Co Giãn Tốt\r\n- Có 1 Lớp\r\n- Không Có Túi\r\n*CHÂN VÁY BÚT CHÌ, LƯNG LIỀN, PHẦN LƯNG CÓ ĐAI TẠO KIỂU, Ở ĐAI CÓ ĐÍNH 1 NÚT NHỰA ĐỂ CỐ ĐỊNH ĐAI VÀO CHÂN VÁY, PHẦN LAI SAU CÓ XẺ TÀ, DÂY KÉO PHÍA SAU.', '275000.00', '0.000', 0, 'chanvay_butchi_one_021.jpg', '[]', 0, 0, 4, 1, 1640008946),
(185, 2, 'CHÂN VÁY JEAN PHỐI TÚI', 'Chân váy jean phối túi\r\n- Tên Sản Phẩm: Chân váy jean phối túi\r\n- Giá Bán: 495,000vnđ\r\n- Màu Sắc: XANH, ĐEN\r\n- Số Đo Eo: 66CM\r\n- Số Đo Mông: 94CM\r\n- Chiều Dài Chân Váy: 42CM\r\n- Thông Số Size S\r\n- Số Size S-M-L-XL\r\n- Chất Liệu Vải: JEANS\r\n- CÓ TÚI\r\n- CÓ QUẦN TRONG\r\n*CHÂN VÁY JEANS FORM A CƠ BẢN, BẢN LƯNG KHOẢNG 3.5CM, CHÂN VÁY CÓ PAGHET, DÂY KÉO Ở GIỮA, CÓ NÚT, SƯỜN BÊN TRÁI CÓ PHỐI TÚI HỘP TẠO KIỂU.', '459000.00', '0.000', 0, 'chanvay_jean_one_021.jpg', '[]', 0, 0, 4, 1, 1640008978),
(186, 2, 'Áo thun nữ Xù màu trơn Thanh lịch', 'Phong cách:	Thanh lịch\r\nMàu sắc:	màu nâu\r\nKiểu mẫu:	màu trơn\r\nChiều dài:	Thường xuyên\r\nMùa:	Mùa Xuân/ Mùa Thu\r\nChi tiết:	Xù\r\nLoại Phù hợp:	Thon gọn\r\nViền:	Đứng cổ áo\r\nChiều dài tay:	Tay áo dài\r\nLoại tay áo:	Tay thường\r\nMỏng:	Không\r\nLoại túi váy:	Áo chui\r\nVải lót:	Không có đường viền\r\nVật liệu:	Polyester\r\nThành phần:	95% Polyester, 5% Spandex\r\nSợi vải:	Căng trung bình\r\nHướng dẫn Bảo quản:	Machine wash or professional dry clean', '215000.00', '0.000', 0, 'aothun_one_02.webp', '[]', 0, 0, 4, 1, 1640009012),
(187, 2, 'Áo thun nữ Nút Trọn gói Gân đan Sọc Giải trí', 'Phong cách:	Giải trí\r\nMàu sắc:	Đen và trắng\r\nKiểu mẫu:	Sọc\r\nChiều dài:	Thường xuyên\r\nMùa:	Mùa Hè\r\nChi tiết:	Nút, Trọn gói, Gân đan\r\nLoại Phù hợp:	Phù hợp thường\r\nViền:	Vòng cổ\r\nChiều dài tay:	Ngắn tay\r\nLoại tay áo:	Tay thường\r\nMỏng:	Không\r\nLoại túi váy:	Áo chui\r\nVật liệu:	Bông\r\nThành phần:	65% Bông, 30% Polyester, 5% Bông vải thun\r\nSợi vải:	Căng trung bình\r\nHướng dẫn Bảo quản:	Machine wash or professional dry clean', '174000.00', '0.000', 0, 'aothun_two_02.webp', '[]', 0, 0, 4, 1, 1640009050),
(233, 6, 'Áo nỉ Hoodie Lục Lăng', 'Chất liệu nỉ dày dặn, form oversize rộng', '367000.00', '0.000', 0, '89c5f53e9d96f77db0019fa21dc9b797.jpg', '[\"89c5f53e9d96f77db0019fa21dc9b7971.jpg\"]', 0, 0, 4, 1, 1640003798),
(234, 0, 'ÁO KHOÁC NỈ HOODIE GẤU', 'Thích Hợp Khi Tham Gia Các Hoạt Động Thể Thao, Đạp Xe, Leo Núi', '187000.00', '0.000', 0, '', '[]', 0, 0, 4, 1, 1640003837),
(235, 5, ' Áo Khoác Dù Bomber Nữ Stay High WOP 2006', 'Áo Khoác Dù Bomber Nữ Stay High WOP 2006 thông điệp “Stay High” được thêu nổi bật ở thân sau áo. Mặt trước có 2 túi. Túi ngực mặt trong áo có dây kéo an toàn.\r\n\r\nChất liệu: Dù bomber ngăn thấm nước\r\nKiểu dáng: Áo bomber trẻ trung\r\nMàu sắc: Đen, rêu\r\nSản xuất tại Việt Nam', '649000.00', '454300.000', 194700, 'aokhoacnu_du.jpg', '[\"aokhoacnu_du02.jpg\"]', 0, 0, 4, 1, 1640003850),
(236, 6, 'Áo Hoodie Họa Tiết Con Bò Sữa', 'Cotton Cao Cấp, Áo khoác Hoodie Zip Nỉ Bông Bò Sữa unisex nam nữ đều mặc được Có Clip Cận Chất', '245000.00', '0.000', 0, 'eef60ad70b2dbdc17d98b20d77aecb8f.jpg', '[\"eef60ad70b2dbdc17d98b20d77aecb8f1.jpg\"]', 0, 0, 4, 1, 1640003893),
(237, 6, 'Áo Hoodie Reunion', 'Với chất liệu nỉ cotton dày dặn và mịn màng, màu sắc độc đáo và theo xu hướng,hình ảnh in trên áo mang nhiều ý nghĩa', '454000.00', '0.000', 0, '87e9eca7f06d1b4c0bdcb615bc279430.jpg', '[\"87e9eca7f06d1b4c0bdcb615bc2794301.jpg\"]', 0, 0, 4, 1, 1640003942),
(239, 5, 'Áo Khoác UV Nữ WOK 2004', 'Áo Khoác UV Nữ WOK 2004 tính năng chống UV vượt trội. Đường may dọc sườn áo tạo đường nét thon thả cho các cô gái. Túi ngoài có dây kéo, túi trong chứa đồ tiện lợi. Vải mềm mại, mỏng nhẹ tạo cảm giác thoải mái, thoáng mát khi mặc.\r\n\r\nChất liệu: Polyester \r\nFrom: Basic\r\nBộ 5 màu đa dạng: Xám, xanh, cam, rêu, vàng\r\nSản xuất: Việt Nam', '499000.00', '299400.000', 199600, 'aokhoacnu_uv.jpg', '[\"aokhoacnu_uv02.jpg\",\"aokhoacnu_uv03.jpg\"]', 0, 0, 4, 1, 1640004035),
(240, 6, 'Áo Hoodie Nam Nữ Unisex ROUGH', 'Chất Nỉ Bông Form Basic Phong Cách Hàn Quốc 5 Màu Trẻ Trung', '389000.00', '0.000', 0, 'caffe91f41893570a028b92da360c5b6.jpg', '[\"caffe91f41893570a028b92da360c5b61.jpg\"]', 0, 0, 4, 1, 1640004093),
(190, 6, 'Áo khoác hoodie họa tiết ASALA', 'Mặt trước áo có in chữ kèm theo họa tiết tạo nên phong cách riêng biệt cho chính bạn', '532000.00', '0.000', 0, 'e9f5c63da3fb627d25948e816fd5fd4c.jpg', '[\"e9f5c63da3fb627d25948e816fd5fd4c1.jpg\"]', 0, 0, 4, 1, 1640004141),
(241, 5, 'Áo Thun Nữ Graphic Hmong WTS 2027', 'Áo Thun Nữ WTS 2027 Graphic \"Hmong\" tạo điểm nhấn nổi bật trên áo, được thiết kế theo phong cách trẻ trung, hợp xu thế hiện đại. Hãy thêm một chút ít đồ và phong cách mới lạ vào tủ quần áo hàng ngày của bạn.\r\n\r\nChất liệu: 100% cotton dày dặn.\r\nKiểu dáng: Relax cá tính, áo rộng vai\r\nMàu sắc: Đen, xám, đỏ.\r\nSản xuất: Việt Nam.', '239000.00', '167300.000', 71700, 'aothunnu_graphic.jpg', '[\"aothunnu_graphic02.jpg\",\"aothunnu_graphic03.jpg\"]', 0, 0, 4, 1, 1640004240),
(242, 6, 'Bộ Chũa A Nam Nỉ Bông', 'Bộ nỉ nam chất da cá ( cá tính mạnh mẽ, đẳng cấp sang trọng cho thu đông )', '259000.00', '0.000', 0, 'fe2a6989c9d762314455defc916e8aba.jpg', '[\"fe2a6989c9d762314455defc916e8aba1.jpg\"]', 0, 0, 4, 1, 1640004255),
(243, 6, 'Bộ Thể Thao Nam Chất Nỉ Hàn Quốc', 'Bộ Thể Thao Nam Chất Nỉ Hàn Quốc, Tay Sọc Năng Động, Thoải Mái', '276000.00', '0.000', 0, 'f90cc7c5db2a4a4236e892c3cd628a89.jpg', '[\"f90cc7c5db2a4a4236e892c3cd628a891.jpg\"]', 0, 0, 4, 1, 1640004298),
(244, 6, 'Bộ Thể Thao Nam Kẻ Sọc', 'Chất cotton, không xù, không bai, không phai màu\r\nMàu sắc đa dạng, phối kết hợp với phong cách khác nhau', '346000.00', '0.000', 0, '1700a490266b3566d07a87dde2f01173.jpg', '[\"1700a490266b3566d07a87dde2f011731.jpg\"]', 0, 0, 4, 1, 1640004372),
(245, 6, 'Bộ Thể Thao Chất Vải Nỉ Da Cá ', 'Bộ nỉ nam thiết kế đơn giản, hợp thời trang tạo cảm giác thoải mái và ấm áp cho người mặc', '339000.00', '0.000', 0, '8605a8ae7ff715babd23152be441bac5.jpg', '[\"8605a8ae7ff715babd23152be441bac51.jpg\"]', 0, 0, 4, 1, 1640004410),
(246, 5, 'Áo Len Nam Phối Màu Zigzag MOS 1002', 'Áo len nam phối màu Ziczag MOS 1002 Couple TX có form suông dễ mặc và phù hợp với mọi dáng người. Áo len thường được các bạn nam ưu ái chọn kết hợp với quần jeans hoặc quần short cho những hoạt động ngày thường vào mùa thu đông.\r\n\r\nChất liệu: Cotton \r\nKiểu dáng: Regular. \r\nMàu sắc: Đen xám, rêu vàng.\r\nSản xuất: Việt Nam', '459000.00', '321300.000', 137700, 'aolennam_phoimau.jpg', '[\"aolennam_phoimau02.jpg\"]', 0, 0, 4, 1, 1640004452),
(247, 6, 'Bộ Nỉ Nam Thể Thao Thương Hiệu Thời Trang VICERO', 'Với chất liệu nỉ cao cấp, dày dặn, co giãn nhẹ giúp người mặc có thể thoải mái vận động mà không cảm thấy khó chịu hay bí bách', '245000.00', '0.000', 0, 'efdf16a15ad424d7e58f00df1ab540ba.jpg', '[\"efdf16a15ad424d7e58f00df1ab540ba1.jpg\"]', 0, 0, 4, 1, 1640004517),
(249, 5, 'Áo Khoác UV Nam Sọc Phản Quang MOP 1003', 'Áo Khoác UV Nam Sọc Phản Quang MOP 1003 dành cho nam với thiết kế đơn giản phù hợp để sử dụng hàng ngày. Áo có độ dày vừa phải, vừa đảm bảo hiệu quả chống nắng vừa giúp bạn cảm thấy thoải mái khi mặc.\r\n\r\nDòng sản phẩm công nghệ chống tia UV.\r\nChất liệu cotton dày dặn.\r\nBề mặt vải có lỗ thoáng khí.\r\nSọc phản quang trên thân áo phát sáng khi có ánh sáng tác động.\r\nĐược trang bị túi áo ngoài và túi trong rộng rãi, chứa được nhiều vật dụng.', '649000.00', '389400.000', 259600, 'aokhoacnam_uv.jpg', '[\"aokhoacnam_uv02.jpg\"]', 0, 0, 4, 1, 1640004600),
(250, 5, 'Áo Sweater Nam Ép Nhung MSW 1002', 'Áo Sweater Nam Ép Nhung MSW 1002 Họa tiết ruộng bậc thang nhìn từ trên cao được in ép nhung tạo điểm nhấn, với form vai xệ phù hợp mọi vóc dáng sẽ là Items không thể thiếu cho mùa thu đông.\r\n\r\nChất liệu áo cào vảy cá:\r\n60% cotton\r\n40 % poly thấm hút\r\nMàu: Vàng tinh tế.\r\nSản xuất: Việt Nam.', '389000.00', '272300.000', 116700, 'aosweaternam_epnhung.jpg', '[\"aosweaternam_epnhung02.jpg\"]', 0, 0, 4, 1, 1640004772),
(251, 5, 'Áo Len Nữ Phối Màu Zigzag WOS 2001', 'Áo len nữ phối màu Ziczag WOS 2001 Couple TX có form oversize dễ mặc và phù hợp với mọi dáng người. Áo len thường được các cô gái ưu ái chọn kết hợp với váy, quần jeans hoặc quần short cho những hoạt động ngày thường vào mùa thu đông.\r\n\r\nChất liệu 100% cotton dệt kim. \r\nÁo nữ form oversize.\r\nPhối màu ziczag bắt mắt. \r\nBộ 2 màu đen – xám, rêu – vàng.', '429000.00', '300300.000', 128700, 'aolenu_phoimau.jpg', '[\"aolennu_phoimau02.jpg\"]', 0, 0, 4, 1, 1640004953),
(252, 5, 'Áo Khoác UV Ninja Nam MOK 1006', 'Áo Khoác UV Ninja Nam MOK 1006 chống tia UV vượt trội dành cho nam được rất nhiều bạn trẻ yêu thích. Chất liệu vải tricot với nhiều lỗ nhỏ tạo sự thoáng mát, bề mặt vải có hoa văn dạng bản đồ cắt lớp lạ mắt. Túi ngoài của áo có dây kéo an toàn, tay áo có phần xỏ ngón giúp bảo vệ đôi bàn tay\r\n\r\nChất liệu: Vải Tricot\r\nCông nghệ Anti UV\r\nChỉ số UPF: 50++\r\n Khả năng chống nắng: 98% phản xạ các tia UV\r\nKiểu dáng:Basic\r\nMàu sắc: Xám, xanh đen, xanh đậm ( xanh đậm thực tế tối hơn hình websize )\r\nSản xuất: Việt Nam', '649000.00', '454300.000', 194700, 'aokhoacnam_uvninja.jpg', '[\"aokhoacnam_uvninja02.jpg\"]', 0, 0, 4, 1, 1640005103),
(253, 0, 'Áo Thun Nữ In Thông Điệp Be A Light WTS 2056', 'Áo Thun Nữ In Thông Điệp Be A Light WTS 2056 Công nghệ In: In ép Nhung. Chất liệu cotton mềm mịn thoáng mát.\r\n\r\nChất liệu: Cotton\r\nForm dáng: Relax, vai hơi rộng\r\nMàu sắc: Trắng, vàng đồng.\r\nSản xuất: Việt Nam.', '229000.00', '160300.000', 68700, '', '[]', 0, 0, 4, 1, 1640005211),
(254, 0, 'Áo Thun Nữ In Thông Điệp Be A Light WTS 2056', 'Áo Thun Nữ In Thông Điệp Be A Light WTS 2056 Công nghệ In: In ép Nhung. Chất liệu cotton mềm mịn thoáng mát.\r\n\r\nChất liệu: Cotton\r\nForm dáng: Relax, vai hơi rộng\r\nMàu sắc: Trắng, vàng đồng.\r\nSản xuất: Việt Nam.', '229000.00', '160300.000', 68700, 'aothunnu_inthongdiep.jpg', '[\"aothunnu_inthongdiep02.jpg\"]', 0, 0, 4, 1, 1640005308),
(255, 5, 'Áo Khoác Unisex Vải Dù', 'Trải qua 5 năm không ngừng phát triển, HADES là một trong những brand tiên phong trong ngành streetwear tại Việt Nam. \r\n\r\n', '620000.00', '559000.000', 10, '2f72a02dc06b610bece3e60c6c30cce1.jpg', '[\"2f72a02dc06b610bece3e60c6c30cce11.jpg\"]', 0, 0, 4, 1, 1640005593),
(256, 5, 'Áo khoác dù nam AKUBA', 'Áo khoác dù phù hợp trong những ngày thời tiết giao mùa từ hạ sang thu', '469000.00', '278000.000', 41, '997e3c5a98b7f9d74ef987789f3ae33a.jpg', '[\"997e3c5a98b7f9d74ef987789f3ae33a1.jpg\"]', 0, 0, 4, 1, 1640005702),
(257, 5, 'Áo khoác gió nam chính hãng Aristino', 'Áo khoác gió nam chính hãng Aristino KJK002W9 mũ tháo rời tiện lợi, chất liệu polyester chống nước, không nhăn nhàu. Áo jacket nam Benzmen', '850000.00', '429000.000', 50, '10204337a0d376fb99e12c26efc5021c.jpg', '[\"10204337a0d376fb99e12c26efc5021c1.jpg\"]', 0, 0, 4, 1, 1640005762),
(258, 5, 'Áo khoác nam 3D 2 lớp dù', '', '550000.00', '225000.000', 50, '5d7414be1d6319dbb632c7a7bb6319e7.jpg', '[\"5d7414be1d6319dbb632c7a7bb6319e71.jpg\"]', 0, 0, 4, 1, 1640005876),
(259, 0, 'Áo POLO nam ngắn tay cổ bẻ', 'Áo POLO nam ngắn tay cổ bẻ Santino chất liệu thể thao co dãn, dáng slim trẻ trung năng động TSP365B858\r\n', '365000.00', '328000.000', 10, 'd7a8fcf333c376817ea7f75a632b6ab5.jpg', '[\"d7a8fcf333c376817ea7f75a632b6ab51.jpg\"]', 0, 0, 4, 1, 1640005938),
(260, 5, 'Áo POLO nam ngắn tay cổ bẻ', 'Áo POLO nam ngắn tay cổ bẻ Santino chất liệu thể thao co dãn, dáng slim trẻ trung năng động TSP365B858\r\n', '365000.00', '328000.000', 10, 'd7a8fcf333c376817ea7f75a632b6ab52.jpg', '[\"d7a8fcf333c376817ea7f75a632b6ab53.jpg\"]', 0, 0, 4, 1, 1640005978),
(261, 5, 'Quần Jean Nam cao cấp', 'Quần Jean Nam cao cấp co dãn 4 chiều Thương Hiệu Chandi, phong cách hàn quốc trẻ trung cá tính MR9011\r\n', '358200.00', '192000.000', 46, '7bcdbe2b1bdc8df7f0675170de92d136.jpg', '[\"7bcdbe2b1bdc8df7f0675170de92d1361.jpg\"]', 0, 0, 4, 1, 1640006104),
(262, 5, 'Quần Jean Nam Thương Hiệu Chandi', 'Quần Jean Nam đẹp dẫn đầu xu hướng Thương Hiệu Chandi , mẫu mới form đẹp tôn dáng không quá ôm mẫu MR9010\r\n', '358200.00', '188000.000', 48, 'fe5d4e480fd1768a0117c85777cb41e6.jpg', '[\"fe5d4e480fd1768a0117c85777cb41e61.jpg\"]', 0, 0, 4, 1, 1640006179),
(263, 5, 'Áo khoác jean nam HAHAMAN', 'Chất liệu vải jean Denim mềm mại, dày dặn, không nhàu không phai màu dù bạn giặt máy. Màu vải được xử lý Wash kỹ không ra màu khi giặt.\r\n\r\n', '300000.00', '168000.000', 44, '5937ececf1a985e0a8663bf61f2c618b.jpg', '[\"5937ececf1a985e0a8663bf61f2c618b1.jpg\"]', 0, 0, 4, 1, 1640006334),
(264, 5, 'Áo khoác hoodie nam AKUBA', 'Áo khoác hoodie nam AKUBA form oversize, chất liệu dày dặn, bền màu 01C513\r\n', '435000.00', '269000.000', 38, '3d0ffe6205eb62f58f9fea0c19458fce.jpg', '[]', 0, 0, 4, 1, 1640006456),
(265, 5, 'Quần dài thể thao nam Jogger', 'Quần dài thể thao nam Jogger 3 sọc ống bo trẻ trung năng động Micado\r\n', '180000.00', '162000.000', 10, 'e083965418fb10f35bd860cd55119f46.jpg', '[\"e083965418fb10f35bd860cd55119f461.jpg\"]', 0, 0, 4, 1, 1640006572),
(266, 5, 'Combo 4 Áo Thun Nam, Cổ Tròn, Ngắn Tay', 'Combo 4 Áo Thun Nam, Cổ Tròn, Ngắn Tay, Vải Lưới Mềm Mịn, Thun Lạnh, Thông Hơi Thoáng Khí, Áo Lót Nam Mặc 4 Mùa Siêu Mát, Co Giãn 4 Chiều, Áo Tập Thể Thao, Tập Gym, Thấm Hút Mồ Hôi Cực Tốt, Phong Cách Trẻ Trung Năng Động\r\n', '495000.00', '134000.000', 73, 'd0cd1460828c9258484aabd976e83da5.jpg', '[\"d0cd1460828c9258484aabd976e83da51.jpg\"]', 0, 0, 4, 1, 1640006673),
(269, 4, 'Thắt Lưng Nam Da Bò Thật', 'Chất liệu: Thắt lưng được làm từ da bò nguyên miếng cắt bản. Đầu khóa dây nịt được làm từ hợp kim đúc nguyên khối, không gỉ, không bạc màu. Phần dây thắt lưng được thuộc da với trình độ cao, chất ra dẻo dai, bền bỉ và cực mềm', '275000.00', '0.000', 0, 'Thắt Lưng Nam Da Bò Thật.jpg', '[]', 0, 0, 4, 1, 1640013945),
(268, 4, 'Thắt Lưng Da Nam Khóa Lăn Tự Động', 'Dây nịt nam, thắt lưng nam với kiểu dáng thiết kế đơn giản sang trọng và tinh tế làm nổi bật phong cách người dùng, dễ dàng phối hợp với các kiểu quần jeans & kaki\r\nThắt lưng nam bản nhỏ 3.0 cm', '150000.00', '0.000', 0, 'Thắt_Lưng_Nam_Mặt_Khóa_Lăn_Tự_Động1.jpg', '[]', 0, 0, 4, 1, 1640013570),
(270, 4, 'Tất nam chấm bi cao cấp - Set 4 đôi', 'Màu sắc: Đen bi xanh lá, xanh navy bi trắng, xanh navy bi xanh, nâu bi trắng\r\nChất liệu: Cotton 80% ; Spandex 20%\r\nĐộ dài: 23-25cm tính từ mắc cá chân\r\n', '199000.00', '0.000', 0, 'Tất_nam_chấm_bi_cao_cấp_-_Set_4_đôi.jpg', '[]', 0, 0, 4, 1, 1640014287),
(272, 1, 'Quần kaki nam', 'Những chiếc quần kaki luôn được các chàng ưu ái lựa chọn bởi thiết kế đơn giản nhưng vẫn mang đến sự khỏe khoắn, năng động và hiện đại.', '185000.00', '0.000', 0, 'b6fe4b1e50ef90c69022107ae4e6bbb1.jpg', '[]', 0, 0, 4, 1, 1640049755);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `slider`
--

CREATE TABLE `slider` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `image_link` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `link` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `sort_order` int(11) NOT NULL,
  `created` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `slider`
--

INSERT INTO `slider` (`id`, `name`, `image_link`, `link`, `sort_order`, `created`) VALUES
(1, '1', 'slide1.png', 'http://localhost/webshop/phoi-ren-p4', 1, '2017-04-25 15:24:43'),
(4, '2', 'slide2.jpg', 'http://localhost/webshop/ao-gia-dinh-ag0560-p16', 4, '2017-04-25 15:36:41'),
(5, '3', 'slide3.jpg', 'http://localhost/webshop/phong-cach-phoi-mau-p24', 3, '2017-04-25 15:37:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  `user_id` int(11) NOT NULL DEFAULT 0,
  `user_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `user_email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `user_phone` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `user_address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `message` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `amount` decimal(15,3) NOT NULL DEFAULT 0.000,
  `payment` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `transaction`
--

INSERT INTO `transaction` (`id`, `status`, `user_id`, `user_name`, `user_email`, `user_phone`, `user_address`, `message`, `amount`, `payment`, `created`) VALUES
(77, 1, 0, 'dang van thong', 'thongdv@gmail.com', '0987112345', '60 hoa minh, lien chieu, da nang', 'giao hang giup em', '449000.000', '', 0),
(76, 1, 0, 'nguyen dinh sang', 'sanghk232@gmail.com', '0972092243', '46 tran phu, huong khe, ha tinh', 'giao hang nhanh giup em voi', '249000.000', '', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`, `phone`, `address`, `created`) VALUES
(12, 'Nguyen Minh Khang', 'khangpro@gmail.com', 'a16bc1e59f3280a592af13679485431f', '096654435', '15 Nguyen Thi  Minh Khai', 0),
(11, 'Truong Tai', 'helokier16@gmail.com', 'Truongtai1', '0954353662132', '09Nguyen Trai', 0),
(18, 'Truong Tai', 'helokier14@gmail.com', 'a16bc1e59f3280a592af13679485431f', '095454233322', '09 Nguyen Trai', 0),
(19, 'Nguyen dinh sang', 'sanghk23@gmil.com', 'e10adc3949ba59abbe56e057f20f883e', '0972092243', 'Day nang', 0),
(20, 'Nguyễn Đình Sáng', 'sang112@gmail.com', '202cb962ac59075b964b07152d234b70', '+84972092243', 'Đà nẵng', 0),
(21, 'nguyen dinh sang', 'sanghk2312@gmil.com', '81dc9bdb52d04dc20036dbd8313ed055', '0972092243', 'da nang', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `catalog`
--
ALTER TABLE `catalog`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `mytable`
--
ALTER TABLE `mytable`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `oderr`
--
ALTER TABLE `oderr`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `slider`
--
ALTER TABLE `slider`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `catalog`
--
ALTER TABLE `catalog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT cho bảng `oderr`
--
ALTER TABLE `oderr`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT cho bảng `order`
--
ALTER TABLE `order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=274;

--
-- AUTO_INCREMENT cho bảng `slider`
--
ALTER TABLE `slider`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
