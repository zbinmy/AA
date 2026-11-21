# Sonata Connect — vehicle compatibility assessment

Assessment baseline: 2021 Hyundai Sonata DN8 Limited, assumed US-market 10.25-inch factory navigation head unit. Confirm the market and exact head-unit software identifier before treating this as vehicle-specific certification.

## Evidence-based findings

| Capability | Assessment | Evidence / boundary |
|---|---|---|
| Android Auto | Supported over USB on the documented navigation configuration | 2021 Sonata quick reference guide says USB data/smartphone port is used for Android Auto and requires a USB cable. |
| Wireless Android Auto | Not established for the 10.25-inch navigation unit; assume unsupported until vehicle test | Hyundai TSB 20-BE-015H describes wireless Android Auto for 2021 Display Audio Value **non-navigation** head units. This is not evidence for the navigation head unit. |
| Bluetooth A2DP | Supported by factory Bluetooth audio streaming | Standard factory Bluetooth media capability; verify pairing and selected media source in vehicle. |
| Bluetooth AVRCP | Expected with factory Bluetooth media controls; exact profile/version not established from retrieved vehicle documentation | Confirm track metadata and steering-wheel control behavior during physical test. |
| Bluetooth HFP | Factory hands-free calling supported | Do not take over the vehicle's hands-free stack; Android app only reports OS-level state and uses public APIs. |
| Wi-Fi Direct | No evidence the head unit exposes a user-accessible Wi-Fi Direct receiver | Discovery may enumerate Android peer devices; it cannot establish a Hyundai receiver capability. |
| Miracast / wireless display | Not documented as a factory Sonata DN8 projection feature | Do not claim compatibility. Requires a separately verified Miracast receiver/display sink. |
| USB | Factory USB data/smartphone port supports wired Android Auto and media input | USB host/device role and data path are controlled by the phone/head unit. App cannot force a projection mode. |
| Arbitrary screen mirroring | Not supported by Android Auto media-app APIs | Not implemented. |

## Source references

- 2021 Hyundai Sonata Quick Reference Guide, “USB Data/Smartphone Port” and “Android Auto” sections: https://device.report/m/ffaaed1c2db38c6cfea3dd38872e4dfbad98ea27ab41f2552322eb8b973850e2
- Hyundai TSB 20-BE-015H (December 2020), wireless Android Auto setup applies to Display Audio Value (Non-Navigation): https://static.nhtsa.gov/odi/tsbs/2020/MC-10185441-0001.pdf
- 2021 Sonata owner's manual: https://www.carmanualdb.com/files/Hyundai%20Sonata%202021%20%28DN8%29%20Owners%20Manual.pdf
- Hyundai official update catalog for Sonata 2020–22: https://update.hyundai.com/US/EN/search?genNm=Sonata+2020-22&pfmCd=PFM14&searchType=model
- Android for Cars media app requirements: https://developer.android.com/training/cars/media

## Navigation software date

Do not treat “March 2026” as the vehicle's installed software version. Hyundai's update catalog is dynamic and varies by region and head-unit platform. Record the exact version shown in Settings → General → SW Info/Update, including platform/model code and map version, then compare it with Hyundai's official VIN/model lookup. Sonata 2020–22 is listed under Standard Gen5W Navigation in the US catalog.

## Physical verification checklist

1. Confirm market, VIN-derived trim, and head-unit type (Navigation vs Display Audio).
2. Photograph/record SW version, platform code, and map version from the head unit.
3. Pair phone over Bluetooth; verify A2DP music and HFP calls separately.
4. Connect a data-capable USB cable to the factory data port; verify Android Auto launch.
5. Test wireless Android Auto only if the head unit exposes an explicit wireless phone-projection setting and completes a real pairing session.
6. Do not infer Miracast/Wi-Fi Direct support from Wi-Fi hardware presence alone.
7. Verify Android Auto's in-car app catalog exposes Sonata Connect after app install and policy eligibility checks.

No physical vehicle or head-unit was available to this repository build. This report is a documented baseline, not a successful in-car test certificate.
